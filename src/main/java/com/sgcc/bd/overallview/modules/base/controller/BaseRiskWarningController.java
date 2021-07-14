package com.sgcc.bd.overallview.modules.base.controller;

import com.sgcc.bd.overallview.common.utils.PageUtil;
import com.sgcc.bd.overallview.common.utils.ResultUtil;
import com.sgcc.bd.overallview.common.vo.PageVo;
import com.sgcc.bd.overallview.common.vo.Result;
import com.sgcc.bd.overallview.modules.base.entity.BaseRiskWarning;
import com.sgcc.bd.overallview.modules.base.query.BaseRiskWarningQuery;
import com.sgcc.bd.overallview.modules.base.service.BaseRiskWarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
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
 * @desc 风险预警表 controller
 * @author chenfeixiang
 * @since 2021-06-18
 */
@RestController
@RequestMapping("/base/baseRiskWarning")
@Slf4j
@ApiModel(value="BaseRiskWarning对象", description="风险预警表")
@Api(tags = "base-风险预警表")
public class BaseRiskWarningController {

    @Autowired
    private BaseRiskWarningService baseRiskWarningService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<BaseRiskWarning> saveOrUpdate(@Valid @RequestBody BaseRiskWarning baseRiskWarning){
        try {
            baseRiskWarningService.saveOrUpdate(baseRiskWarning);
            return  ResultUtil.data(baseRiskWarning);
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
    public Result<Page<BaseRiskWarning>> list(PageVo pageVo, BaseRiskWarningQuery query) {
        QueryWrapper<BaseRiskWarning> queryWrapper = new QueryWrapper<BaseRiskWarning>() ;
        queryWrapper.lambda().eq(BaseRiskWarning::getSiteId,query.getSiteId());
        queryWrapper.lambda().like(query.getCompany()!=null,BaseRiskWarning::getCompany,query.getCompany());
        queryWrapper.lambda().eq(query.getRiskLevel()!=null,BaseRiskWarning::getRiskLevel,query.getRiskLevel());
        queryWrapper.lambda().like(query.getReceivingDepartment()!=null,BaseRiskWarning::getReceivingDepartment,query.getReceivingDepartment());
        queryWrapper.lambda().gt(query.getStartTime()!= null ,BaseRiskWarning::getDatee,query.getStartTime()); //时间开始
        queryWrapper.lambda().lt(query.getEndTime() != null,BaseRiskWarning::getDatee,query.getEndTime());//结束时间
        //TODO 条件待填写
        Page page = baseRiskWarningService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             baseRiskWarningService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<BaseRiskWarning> getById(BaseReqVO request) {
        try {
            BaseRiskWarning baseRiskWarning = baseRiskWarningService.getById(request.getId());
            return  ResultUtil.data(baseRiskWarning);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

