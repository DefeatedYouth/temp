package com.sgcc.bd.overallview.modules.overview.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.thread.ThreadUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.sgcc.bd.overallview.common.enums.EnumNodeType;
import com.sgcc.bd.overallview.common.utils.PageUtil;
import com.sgcc.bd.overallview.common.utils.ResultUtil;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.common.vo.PageVo;
import com.sgcc.bd.overallview.common.vo.Result;
import com.sgcc.bd.overallview.modules.anxiaofang.dto.*;
import com.sgcc.bd.overallview.modules.anxiaofang.entity.AxfDevice;
import com.sgcc.bd.overallview.modules.anxiaofang.query.AxfDeviceQuery;
import com.sgcc.bd.overallview.modules.anxiaofang.service.AxfDeviceService;
import com.sgcc.bd.overallview.modules.base.service.BaseDeviceService;
import com.sgcc.bd.overallview.modules.job.entity.JobMaintenanceWork;
import com.sgcc.bd.overallview.modules.job.entity.JobOperationTicket;
import com.sgcc.bd.overallview.modules.job.entity.JobRepair;
import com.sgcc.bd.overallview.modules.job.entity.JobTicket;
import com.sgcc.bd.overallview.modules.job.query.JobMaintenanceWorkQuery;
import com.sgcc.bd.overallview.modules.job.query.JobOperationTicketQuery;
import com.sgcc.bd.overallview.modules.job.query.JobRepairQuery;
import com.sgcc.bd.overallview.modules.job.query.JobTicketQuery;
import com.sgcc.bd.overallview.modules.job.service.JobMaintenanceWorkService;
import com.sgcc.bd.overallview.modules.job.service.JobOperationTicketService;
import com.sgcc.bd.overallview.modules.job.service.JobRepairService;
import com.sgcc.bd.overallview.modules.job.service.JobTicketService;
import com.sgcc.bd.overallview.modules.robot.service.RobotInspMessageService;
import com.sgcc.bd.overallview.modules.shebei.service.SbBookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * @description: 作业首页
 * @author: bbsn
 * @Time: 2021/7/14 15:34
 * @Params:
 */
@RestController
@RequestMapping("/job")
@Slf4j
@ApiModel(value="作业首页", description="作业首页信息展示")
@Api(tags = "作业首页信息展示")
public class JobController {

    @Autowired
    private JobTicketService jobTicketService;

    @Autowired
    private JobRepairService jobRepairService;

    @Autowired
    private JobOperationTicketService jobOperationTicketService;

    @Autowired
    private JobMaintenanceWorkService jobMaintenanceWorkService;


    /**
     * @desc 新增或更新,带id为修改，不带id为新增 提交的成功嘛
     */
    @ApiOperation("获取工作票信息")
    @GetMapping("/getJobTicketList")
    public Result<Page<JobTicket>> getJobTicketList(PageVo pageVo, JobTicketQuery query) {
        QueryWrapper<JobTicket> queryWrapper = new QueryWrapper<JobTicket>() ;
        queryWrapper.lambda().eq(JobTicket::getSiteId,query.getSiteId());
        queryWrapper.lambda().like(query.getTicketNumber()!=null,JobTicket::getTicketNumber,query.getTicketNumber());
        queryWrapper.lambda().eq(query.getTicketType()!=null,JobTicket::getTicketType,query.getTicketType());
        queryWrapper.lambda().like(query.getTicketOrgname()!=null,JobTicket::getTicketOrgname,query.getTicketOrgname());
        queryWrapper.lambda().like(query.getTicketPerson()!=null,JobTicket::getTicketPerson,query.getTicketPerson());
        queryWrapper.lambda().like(query.getPermitPersion()!=null,JobTicket::getPermitPersion,query.getPermitPersion());
        queryWrapper.lambda().gt(query.getStartTime()!= null ,JobTicket::getTicketPlanTime,query.getStartTime()); //时间开始
        queryWrapper.lambda().lt(query.getEndTime() != null,JobTicket::getTicketPlanTime,query.getEndTime());//结束时间
        //TODO 条件待填写
        Page page = jobTicketService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("获取运维检修信息")
    @GetMapping("/operationMaintenance")
    public Result<Page<JobRepair>> operationMaintenance(PageVo pageVo, JobRepairQuery query) {
        QueryWrapper<JobRepair> queryWrapper = new QueryWrapper<JobRepair>() ;
        queryWrapper.lambda().eq(JobRepair::getSiteId,query.getSiteId());
        queryWrapper.lambda().like(query.getWorkBanzhu()!=null,JobRepair::getWorkBanzhu,query.getWorkBanzhu());
        queryWrapper.lambda().like(query.getPersonCharge()!=null,JobRepair::getPersonCharge,query.getPersonCharge());
        queryWrapper.lambda().eq(query.getPlanType()!=null,JobRepair::getPlanType,query.getPlanType());
        queryWrapper.lambda().eq(query.getIsComplan()!=null,JobRepair::getIsComplan,query.getIsComplan());
        queryWrapper.lambda().gt(query.getOrganizationStartTime()!= null ,JobRepair::getPlanTime,query.getOrganizationStartTime());
        queryWrapper.lambda().lt(query.getOrganizationEndTime() != null,JobRepair::getPlanTime,query.getOrganizationEndTime());
        queryWrapper.lambda().gt(query.getSstartTime()!= null ,JobRepair::getBeginTime,query.getSstartTime());
        queryWrapper.lambda().lt(query.getSendTime()!= null,JobRepair::getBeginTime,query.getSendTime());
        queryWrapper.lambda().gt(query.getEstartTime()!= null ,JobRepair::getEndTime,query.getEstartTime());
        queryWrapper.lambda().lt(query.getEendTime() != null,JobRepair::getEndTime,query.getEendTime());
        queryWrapper.lambda().eq(query.getState() != null,JobRepair::getState,query.getState());
        //TODO 条件待填写
        int oneDay = 24*60*60*1000;
        Page page = jobRepairService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        List<JobRepair> records = page.getRecords();
        records.forEach(record ->{
           Long time =  System.currentTimeMillis() - record.getBeginTime().getTime();
           if (time<= 7*oneDay&&time>0){
                record.setJobRepairState(0);
           }
            if (time<0){
                record.setJobRepairState(1);
            }
        });
        return ResultUtil.data(page);
    }

    @ApiOperation("操作票列表")
    @GetMapping("/operationTicketList")
    public Result<Page<JobOperationTicket>> operationTicketList(PageVo pageVo, JobOperationTicketQuery query) {
        QueryWrapper<JobOperationTicket> queryWrapper = new QueryWrapper<JobOperationTicket>() ;
        queryWrapper.lambda().eq(JobOperationTicket::getSiteId,query.getSiteId());
        queryWrapper.lambda().eq(query.getTicketStatus()!=null,JobOperationTicket::getTicketStatus,query.getTicketStatus());
        queryWrapper.lambda().like(query.getOperationSteps()!=null,JobOperationTicket::getOperationSteps,query.getOperationSteps());
        queryWrapper.lambda().gt(query.getMakeStartTime()!= null ,JobOperationTicket::getTicketMakingTime,query.getMakeStartTime());
        queryWrapper.lambda().lt(query.getMakeEndTime() != null,JobOperationTicket::getTicketMakingTime,query.getMakeEndTime());
        queryWrapper.lambda().gt(query.getOperationStartTime()!= null ,JobOperationTicket::getOperationStartTime,query.getOperationStartTime());
        queryWrapper.lambda().lt(query.getOperationSendTime()!= null,JobOperationTicket::getOperationStartTime,query.getOperationSendTime());
        queryWrapper.lambda().gt(query.getOperationEndStartTime()!= null ,JobOperationTicket::getTicketMakingTime,query.getOperationEndStartTime());
        queryWrapper.lambda().lt(query.getOperationEndTime() != null,JobOperationTicket::getOperationSteps,query.getOperationEndTime());
        //TODO 条件待填写
        Page page = jobOperationTicketService.page(PageUtil.initMpPage(pageVo),queryWrapper);

        List<JobOperationTicket> jobOperationTickets = jobOperationTicketService.getBaseMapper().selectList(new QueryWrapper<JobOperationTicket>().lambda()
                .eq(JobOperationTicket::getSiteId, query.getSiteId())
                .gt(JobOperationTicket::getTicketMakingTime, new Date())
                .lt(JobOperationTicket::getOperationSteps, new Date())
                .select(JobOperationTicket::getOperationTask)
        );
        return ResultUtil.data(page);
    }


    @ApiOperation("操作票列表提示")
    @GetMapping("/getOperationTicketWarn")
    public Result<List<JobOperationTicket>> getOperationTicketWarn(PageVo pageVo, JobOperationTicketQuery query) {

        List<JobOperationTicket> jobOperationTickets = jobOperationTicketService.getBaseMapper().selectList(new QueryWrapper<JobOperationTicket>().lambda()
                .eq(JobOperationTicket::getSiteId, query.getSiteId())
                .gt(JobOperationTicket::getTicketMakingTime, new Date())
                .lt(JobOperationTicket::getOperationSteps, new Date())
                .select(JobOperationTicket::getOperationTask)
        );
        return ResultUtil.data(jobOperationTickets);
    }


    @ApiOperation("维护作业统计")
    @GetMapping("/maintenanceWorkList")
    public Result<Page<JobMaintenanceWork>> maintenanceWorkList(PageVo pageVo, JobMaintenanceWorkQuery query) {
        QueryWrapper<JobMaintenanceWork> queryWrapper = new QueryWrapper<JobMaintenanceWork>() ;
        queryWrapper.lambda().eq(JobMaintenanceWork::getSiteId,query.getSiteId());
        queryWrapper.lambda().like(query.getMaintenanceProject()!=null,JobMaintenanceWork::getMaintenanceProject,query.getMaintenanceProject());
        queryWrapper.lambda().like(query.getOperators()!=null,JobMaintenanceWork::getOperators,query.getOperators());
        queryWrapper.lambda().gt(query.getStartTime()!= null ,JobMaintenanceWork::getLastMaintenanceTime,query.getStartTime());
        queryWrapper.lambda().lt(query.getEndTime() != null,JobMaintenanceWork::getLastMaintenanceTime,query.getEndTime());
        queryWrapper.lambda().groupBy(JobMaintenanceWork::getLastMaintenanceTime);
        Page page = jobMaintenanceWorkService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

}

