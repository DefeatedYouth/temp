package com.sgcc.bd.overallview.modules.job.controller;

import com.sgcc.bd.overallview.common.utils.PageUtil;
import com.sgcc.bd.overallview.common.utils.ResultUtil;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.common.vo.PageVo;
import com.sgcc.bd.overallview.common.vo.Result;
import com.sgcc.bd.overallview.modules.job.entity.JobMaintenanceWork;
import com.sgcc.bd.overallview.modules.job.query.JobMaintenanceTasksQuery;
import com.sgcc.bd.overallview.modules.job.query.JobMaintenanceWorkQuery;
import com.sgcc.bd.overallview.modules.job.service.JobMaintenanceWorkService;
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
@RequestMapping("/job/jobMaintenanceWork")
@Slf4j
    @ApiModel(value="JobMaintenanceWork对象", description="")
@Api(tags = "job-")
public class JobMaintenanceWorkController {

    @Autowired
    private JobMaintenanceWorkService jobMaintenanceWorkService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<JobMaintenanceWork> saveOrUpdate(@Valid @RequestBody JobMaintenanceWork jobMaintenanceWork){
        try {
            jobMaintenanceWorkService.saveOrUpdate(jobMaintenanceWork);
            return  ResultUtil.data(jobMaintenanceWork);
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
    public Result<Page<JobMaintenanceWork>> list(PageVo pageVo, JobMaintenanceWorkQuery query) {
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

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             jobMaintenanceWorkService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<JobMaintenanceWork> getById(BaseReqVO request) {
        try {
            JobMaintenanceWork jobMaintenanceTasks = jobMaintenanceWorkService.getById(request.getId());
            return  ResultUtil.data(jobMaintenanceTasks);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

