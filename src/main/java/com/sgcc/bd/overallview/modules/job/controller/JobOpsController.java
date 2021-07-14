package com.sgcc.bd.overallview.modules.job.controller;

import com.sgcc.bd.overallview.common.utils.PageUtil;
import com.sgcc.bd.overallview.common.utils.ResultUtil;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.common.vo.PageVo;
import com.sgcc.bd.overallview.common.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import com.sgcc.bd.overallview.modules.job.entity.JobOps;
import com.sgcc.bd.overallview.modules.job.query.JobOpsQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import com.sgcc.bd.overallview.modules.job.service.JobOpsService;

/**
 * @desc 运维作业表 controller
 * @author chenfeixiang
 * @since 2021-06-08
 */
@RestController
@RequestMapping("/job/jobOps")
@Slf4j
@ApiModel(value="JobOps对象", description="运维作业表")
@Api(tags = "job-运维作业表")
public class JobOpsController {

    @Autowired
    private JobOpsService jobOpsService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<JobOps> saveOrUpdate(@Valid @RequestBody JobOps jobOps){
        try {
            jobOpsService.saveOrUpdate(jobOps);
            return  ResultUtil.data(jobOps);
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
    public Result<Page<JobOps>> list(PageVo pageVo, JobOpsQuery query) {
        QueryWrapper<JobOps> queryWrapper = new QueryWrapper<JobOps>() ;
        //TODO 条件待填写
        Page page = jobOpsService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             jobOpsService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<JobOps> getById(BaseReqVO request) {
        try {
            JobOps jobOps = jobOpsService.getById(request.getId());
            return  ResultUtil.data(jobOps);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

