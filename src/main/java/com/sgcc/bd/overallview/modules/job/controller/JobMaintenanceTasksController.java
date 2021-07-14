package com.sgcc.bd.overallview.modules.job.controller;

import com.sgcc.bd.overallview.common.utils.PageUtil;
import com.sgcc.bd.overallview.common.utils.ResultUtil;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.common.vo.PageVo;
import com.sgcc.bd.overallview.common.vo.Result;
import com.sgcc.bd.overallview.modules.job.query.JobMaintenanceTasksQuery;
import com.sgcc.bd.overallview.modules.job.service.JobMaintenanceTasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import com.sgcc.bd.overallview.modules.job.entity.JobMaintenanceTasks;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;

/**
 * @desc  controller
 * @author chenfeixiang
 * @since 2021-07-13
 */
@RestController
@RequestMapping("/job/jobMaintenanceTasks")
@Slf4j
@ApiModel(value="JobMaintenanceTasks对象", description="")
@Api(tags = "job-")
public class JobMaintenanceTasksController {

    @Autowired
    private JobMaintenanceTasksService jobMaintenanceTasksService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<JobMaintenanceTasks> saveOrUpdate(@Valid @RequestBody JobMaintenanceTasks jobMaintenanceTasks){
        try {
            jobMaintenanceTasksService.saveOrUpdate(jobMaintenanceTasks);
            return  ResultUtil.data(jobMaintenanceTasks);
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
    public Result<Page<JobMaintenanceTasks>> list(PageVo pageVo, JobMaintenanceTasksQuery query) {
        QueryWrapper<JobMaintenanceTasks> queryWrapper = new QueryWrapper<JobMaintenanceTasks>() ;
        queryWrapper.lambda().eq(JobMaintenanceTasks::getSiteId,query.getSiteId());
        queryWrapper.lambda().like(query.getCity()!=null,JobMaintenanceTasks::getCity,query.getCity());
        queryWrapper.lambda().like(query.getSiteName()!=null,JobMaintenanceTasks::getSiteName,query.getSiteName());
        queryWrapper.lambda().like(query.getWorkingTeam()!=null,JobMaintenanceTasks::getWorkingTeam,query.getWorkingTeam()!=null);
        queryWrapper.lambda().like(query.getMaintenanceProject()!=null,JobMaintenanceTasks::getMaintenanceProject,query.getMaintenanceProject());
        queryWrapper.lambda().gt(query.getStartTime()!= null ,JobMaintenanceTasks::getMaintenanceDate,query.getStartTime());
        queryWrapper.lambda().lt(query.getEndTime() != null,JobMaintenanceTasks::getMaintenanceDate,query.getEndTime());

        //TODO 条件待填写
        Page page = jobMaintenanceTasksService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             jobMaintenanceTasksService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<JobMaintenanceTasks> getById(BaseReqVO request) {
        try {
            JobMaintenanceTasks jobMaintenanceTasks = jobMaintenanceTasksService.getById(request.getId());
            return  ResultUtil.data(jobMaintenanceTasks);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

