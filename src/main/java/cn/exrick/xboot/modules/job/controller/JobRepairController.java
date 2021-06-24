package cn.exrick.xboot.modules.job.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.utils.*;
import cn.exrick.xboot.modules.job.entity.JobRepair;
import cn.exrick.xboot.modules.job.query.JobRepairQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.modules.job.service.JobRepairService;

import java.util.List;
import cn.exrick.xboot.common.vo.Result;
/**
 * @desc 检修作业表 controller
 * @author chenfeixiang
 * @since 2021-06-08
 */
@RestController
@RequestMapping("/job/jobRepair")
@Slf4j
@ApiModel(value="JobRepair对象", description="检修作业表")
@Api(tags = "job-检修作业表")
public class JobRepairController {

    @Autowired
    private JobRepairService jobRepairService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<JobRepair> saveOrUpdate(@Valid @RequestBody JobRepair jobRepair){
        try {
            jobRepairService.saveOrUpdate(jobRepair);
            return  ResultUtil.data(jobRepair);
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
    public Result<Page<JobRepair>> list(PageVo pageVo,JobRepairQuery query) {
        QueryWrapper<JobRepair> queryWrapper = new QueryWrapper<JobRepair>() ;
        queryWrapper.lambda().eq(JobRepair::getSiteId,query.getSiteId());
        queryWrapper.lambda().like(query.getWorkBanzhu()!=null,JobRepair::getWorkBanzhu,query.getWorkBanzhu());
        queryWrapper.lambda().like(query.getPersonCharge()!=null,JobRepair::getPersonCharge,query.getPersonCharge());
        queryWrapper.lambda().eq(query.getPlanType()!=null,JobRepair::getPlanType,query.getPlanType());
        queryWrapper.lambda().eq(query.getIsComplan()!=null,JobRepair::getIsComplan,query.getIsComplan());
        queryWrapper.lambda().gt(query.getOrganizationStartTime()!= null ,JobRepair::getPlanTime,query.getOrganizationStartTime()); //时间开始
        queryWrapper.lambda().lt(query.getOrganizationEndTime() != null,JobRepair::getPlanTime,query.getOrganizationEndTime());//结束时间
        queryWrapper.lambda().gt(query.getSstartTime()!= null ,JobRepair::getBeginTime,query.getSstartTime()); //时间开始
        queryWrapper.lambda().lt(query.getSendTime()!= null,JobRepair::getBeginTime,query.getSendTime());//结束时间
        queryWrapper.lambda().gt(query.getEstartTime()!= null ,JobRepair::getEndTime,query.getEstartTime()); //时间开始
        queryWrapper.lambda().lt(query.getEendTime() != null,JobRepair::getEndTime,query.getEendTime());//结束时间
        //TODO 条件待填写
        Page page = jobRepairService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             jobRepairService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<JobRepair> getById(BaseReqVO request) {
        try {
            JobRepair jobRepair = jobRepairService.getById(request.getId());
            return  ResultUtil.data(jobRepair);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

