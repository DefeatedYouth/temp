package com.sgcc.bd.overallview.modules.shebei.controller;

import com.sgcc.bd.overallview.common.utils.PageUtil;
import com.sgcc.bd.overallview.common.utils.ResultUtil;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.common.vo.PageVo;
import com.sgcc.bd.overallview.common.vo.Result;
import com.sgcc.bd.overallview.modules.shebei.entity.SbPlanAidedDecision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.utils.*;
import com.sgcc.bd.overallview.modules.shebei.query.SbPlanAidedDecisionQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import com.sgcc.bd.overallview.modules.shebei.service.SbPlanAidedDecisionService;

/**
 * @desc 计划辅助决策表 controller
 * @author chenfeixiang
 * @since 2021-07-07
 */
@RestController
@RequestMapping("/shebei/sbPlanAidedDecision")
@Slf4j
@ApiModel(value="SbPlanAidedDecision对象", description="计划辅助决策表")
@Api(tags = "shebei-计划辅助决策表")
public class SbPlanAidedDecisionController {

    @Autowired
    private SbPlanAidedDecisionService sbPlanAidedDecisionService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<SbPlanAidedDecision> saveOrUpdate(@Valid @RequestBody SbPlanAidedDecision sbPlanAidedDecision){
        try {
            sbPlanAidedDecisionService.saveOrUpdate(sbPlanAidedDecision);
            return  ResultUtil.data(sbPlanAidedDecision);
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
    public Result<Page<SbPlanAidedDecision>> list(PageVo pageVo, SbPlanAidedDecisionQuery query) {
        QueryWrapper<SbPlanAidedDecision> queryWrapper = new QueryWrapper<SbPlanAidedDecision>() ;
        queryWrapper.lambda().eq(query.getSiteId()!=null,SbPlanAidedDecision::getSiteId,query.getSiteId());
        queryWrapper.lambda().like(query.getDeviceName()!=null,SbPlanAidedDecision::getDeviceName,query.getDeviceName());
        queryWrapper.lambda().like(query.getManufacturer()!=null,SbPlanAidedDecision::getManufacturer,query.getManufacturer());
        queryWrapper.lambda().eq(query.getDefect()!=null,SbPlanAidedDecision::getDefect,query.getDefect());
        queryWrapper.lambda().gt(query.getRunStartTime()!= null ,SbPlanAidedDecision::getCommissioningDate,query.getRunStartTime());
        queryWrapper.lambda().lt(query.getRunEndTime() != null,SbPlanAidedDecision::getCommissioningDate,query.getRunEndTime());
        queryWrapper.lambda().gt(query.getOverhaulStartTime()!= null ,SbPlanAidedDecision::getLastOverhaulTime,query.getOverhaulStartTime());
        queryWrapper.lambda().lt(query.getOverhaulEndTime() != null,SbPlanAidedDecision::getLastOverhaulTime,query.getOverhaulEndTime());
        queryWrapper.lambda().gt(query.getTestingStartTime()!= null ,SbPlanAidedDecision::getLastTestTime,query.getTestingStartTime());
        queryWrapper.lambda().lt(query.getTestingEndTime() != null,SbPlanAidedDecision::getLastTestTime,query.getTestingEndTime());
        //TODO 条件待填写
        Page page = sbPlanAidedDecisionService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             sbPlanAidedDecisionService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<SbPlanAidedDecision> getById(BaseReqVO request) {
        try {
            SbPlanAidedDecision sbPlanAidedDecision = sbPlanAidedDecisionService.getById(request.getId());
            return  ResultUtil.data(sbPlanAidedDecision);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

