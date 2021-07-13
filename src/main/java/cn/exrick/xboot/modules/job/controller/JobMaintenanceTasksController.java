package cn.exrick.xboot.modules.job.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.job.entity.JobMaintenanceTasks;
import cn.exrick.xboot.modules.job.query.JobMaintenanceTasksQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.job.service.JobMaintenanceTasksService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
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
    public Result<Page<JobMaintenanceTasks>> list(PageVo pageVo,JobMaintenanceTasksQuery query) {
        QueryWrapper<JobMaintenanceTasks> queryWrapper = new QueryWrapper<JobMaintenanceTasks>() ;
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

