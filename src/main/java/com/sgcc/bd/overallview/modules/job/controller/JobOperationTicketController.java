package com.sgcc.bd.overallview.modules.job.controller;

import com.sgcc.bd.overallview.common.utils.ResultUtil;
import com.sgcc.bd.overallview.common.utils.PageUtil;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.common.vo.PageVo;
import com.sgcc.bd.overallview.common.vo.Result;
import com.sgcc.bd.overallview.modules.job.entity.JobOperationTicket;
import com.sgcc.bd.overallview.modules.job.query.JobOperationTicketQuery;
import com.sgcc.bd.overallview.modules.job.service.JobOperationTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.utils.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;

/**
 * @desc 操作票表 controller
 * @author chenfeixiang
 * @since 2021-07-08
 */
@RestController
@RequestMapping("/job/jobOperationTicket")
@Slf4j
@ApiModel(value="JobOperationTicket对象", description="操作票表")
@Api(tags = "job-操作票表")
public class JobOperationTicketController {

    @Autowired
    private JobOperationTicketService jobOperationTicketService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<JobOperationTicket> saveOrUpdate(@Valid @RequestBody JobOperationTicket jobOperationTicket){
        try {
            jobOperationTicketService.saveOrUpdate(jobOperationTicket);
            return  ResultUtil.data(jobOperationTicket);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
    /**
     * @desc 分页列表查询
     * @param query 分页查询对象
     * @return 分页结果集
     */
    @ApiOperation("列表")
    @GetMapping("/list")
    public Result<Page<JobOperationTicket>> list(PageVo pageVo, JobOperationTicketQuery query) {
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
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             jobOperationTicketService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<JobOperationTicket> getById(BaseReqVO request) {
        try {
            JobOperationTicket jobOperationTicket = jobOperationTicketService.getById(request.getId());
            return  ResultUtil.data(jobOperationTicket);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

