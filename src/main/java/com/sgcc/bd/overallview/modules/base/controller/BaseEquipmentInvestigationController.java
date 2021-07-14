package com.sgcc.bd.overallview.modules.base.controller;

import com.sgcc.bd.overallview.common.utils.PageUtil;
import com.sgcc.bd.overallview.common.utils.ResultUtil;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.common.vo.PageVo;
import com.sgcc.bd.overallview.common.vo.Result;
import com.sgcc.bd.overallview.modules.base.query.BaseEquipmentInvestigationQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import com.sgcc.bd.overallview.modules.base.entity.BaseEquipmentInvestigation;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import com.sgcc.bd.overallview.modules.base.service.BaseEquipmentInvestigationService;

/**
 * @desc 设备排查表 controller
 * @author chenfeixiang
 * @since 2021-07-07
 */
@RestController
@RequestMapping("/base/baseEquipmentInvestigation")
@Slf4j
@ApiModel(value="BaseEquipmentInvestigation对象", description="设备排查表")
@Api(tags = "base-设备排查表")
public class BaseEquipmentInvestigationController {

    @Autowired
    private BaseEquipmentInvestigationService baseEquipmentInvestigationService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<BaseEquipmentInvestigation> saveOrUpdate(@Valid @RequestBody BaseEquipmentInvestigation baseEquipmentInvestigation){
        try {
            baseEquipmentInvestigationService.saveOrUpdate(baseEquipmentInvestigation);
            return  ResultUtil.data(baseEquipmentInvestigation);
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
    public Result<Page<BaseEquipmentInvestigation>> list(PageVo pageVo, BaseEquipmentInvestigationQuery query) {
        QueryWrapper<BaseEquipmentInvestigation> queryWrapper = new QueryWrapper<BaseEquipmentInvestigation>() ;
        //TODO 条件待填写
        queryWrapper.lambda().eq(query.getSiteId()!=null,BaseEquipmentInvestigation::getSiteId,query.getSiteId());
        queryWrapper.lambda().eq(query.getSiteId()!=null,BaseEquipmentInvestigation::getLookFlag,1);
        queryWrapper.lambda().like(query.getManufacturer()!=null,BaseEquipmentInvestigation::getManufacturer,query.getManufacturer());
        queryWrapper.lambda().like(query.getEquipmentModel()!=null,BaseEquipmentInvestigation::getEquipmentModel,query.getEquipmentModel());
        queryWrapper.lambda().like(query.getVoltageLevel()!=null,BaseEquipmentInvestigation::getVoltageLevel,query.getVoltageLevel());
        queryWrapper.lambda().gt(query.getStartTime()!= null ,BaseEquipmentInvestigation::getCommissioningDate,query.getStartTime());
        queryWrapper.lambda().lt(query.getEndTime() != null,BaseEquipmentInvestigation::getCommissioningDate,query.getEndTime());
        queryWrapper.lambda().gt(query.getProductionStartTime()!= null ,BaseEquipmentInvestigation::getDateManufacture,query.getProductionStartTime());
        queryWrapper.lambda().lt(query.getProductionEndTime() != null,BaseEquipmentInvestigation::getDateManufacture,query.getProductionEndTime());
        Page page = baseEquipmentInvestigationService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             baseEquipmentInvestigationService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<BaseEquipmentInvestigation> getById(BaseReqVO request) {
        try {
            BaseEquipmentInvestigation baseEquipmentInvestigation = baseEquipmentInvestigationService.getById(request.getId());
            return  ResultUtil.data(baseEquipmentInvestigation);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

