package com.sgcc.bd.overallview.modules.job.controller;

import com.sgcc.bd.overallview.common.utils.PageUtil;
import com.sgcc.bd.overallview.common.utils.ResultUtil;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.common.vo.PageVo;
import com.sgcc.bd.overallview.common.vo.Result;
import com.sgcc.bd.overallview.modules.job.query.JobPatrolTaskQuery;
import com.sgcc.bd.overallview.modules.job.service.JobPatrolTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import com.sgcc.bd.overallview.modules.job.entity.JobPatrolTask;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;

/**
 * @desc 巡视任务表 controller
 * @author chenfeixiang
 * @since 2021-07-14
 */
@RestController
@RequestMapping("/job/jobPatrolTask")
@Slf4j
@ApiModel(value="JobPatrolTask对象", description="巡视任务表")
@Api(tags = "job-巡视任务表")
public class JobPatrolTaskController {

    @Autowired
    private JobPatrolTaskService jobPatrolTaskService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<JobPatrolTask> saveOrUpdate(@Valid @RequestBody JobPatrolTask jobPatrolTask){
        try {
            jobPatrolTaskService.saveOrUpdate(jobPatrolTask);
            return  ResultUtil.data(jobPatrolTask);
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
    public Result<Page<JobPatrolTask>> list(PageVo pageVo, JobPatrolTaskQuery query) {

        QueryWrapper<JobPatrolTask> queryWrapper = new QueryWrapper<JobPatrolTask>() ;
        queryWrapper.lambda().eq(JobPatrolTask::getSiteId,query.getSiteId());
        queryWrapper.lambda().like(query.getCityOrgname()!=null,JobPatrolTask::getCityOrgname,query.getCityOrgname());
        queryWrapper.lambda().like(query.getWorkOrgname()!=null,JobPatrolTask::getWorkOrgname,query.getWorkOrgname());
        queryWrapper.lambda().like(query.getWorkBanzhu()!=null,JobPatrolTask::getWorkBanzhu,query.getWorkBanzhu());
        queryWrapper.lambda().gt(query.getPlanOverStartTime()!= null ,JobPatrolTask::getScheduledTourDueTime,query.getPlanOverStartTime());
        queryWrapper.lambda().lt(query.getPlanOverEndTime() != null,JobPatrolTask::getScheduledTourDueTime,query.getPlanOverEndTime());
        queryWrapper.lambda().gt(query.getInspectionsStartTime()!= null ,JobPatrolTask::getInspectionStartTime,query.getInspectionsStartTime());
        queryWrapper.lambda().lt(query.getInspectionsEndTime() != null,JobPatrolTask::getInspectionStartTime,query.getInspectionsEndTime());
        queryWrapper.lambda().gt(query.getInspectioneStartTime()!= null ,JobPatrolTask::getInspectionEndTime,query.getInspectioneStartTime());
        queryWrapper.lambda().lt(query.getInspectioneEndTime() != null,JobPatrolTask::getInspectionEndTime,query.getInspectioneEndTime());
        queryWrapper.lambda().gt(query.getOverStartTime()!= null ,JobPatrolTask::getInspectionOverTime,query.getOverStartTime());
        queryWrapper.lambda().lt(query.getOverEndTime() != null,JobPatrolTask::getInspectionOverTime,query.getOverEndTime());

        //TODO 条件待填写
        Page page = jobPatrolTaskService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             jobPatrolTaskService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<JobPatrolTask> getById(BaseReqVO request) {
        try {
            JobPatrolTask jobPatrolTask = jobPatrolTaskService.getById(request.getId());
            return  ResultUtil.data(jobPatrolTask);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

