package com.sgcc.bd.overallview.modules.shebei.controller;

import com.sgcc.bd.overallview.common.utils.ResultUtil;
import com.sgcc.bd.overallview.common.utils.PageUtil;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.common.vo.PageVo;
import com.sgcc.bd.overallview.common.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import cn.exrick.xboot.common.utils.*;
import com.sgcc.bd.overallview.modules.shebei.entity.SbSecondaryEquipmentMonitoring;
import com.sgcc.bd.overallview.modules.shebei.query.SbSecondaryEquipmentMonitoringQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import com.sgcc.bd.overallview.modules.shebei.service.SbSecondaryEquipmentMonitoringService;

/**
 * @desc 二次设备监视表 controller
 * @author chenfeixiang
 * @since 2021-07-07
 */
@RestController
@RequestMapping("/shebei/sbSecondaryEquipmentMonitoring")
@Slf4j
@ApiModel(value="SbSecondaryEquipmentMonitoring对象", description="二次设备监视表")
@Api(tags = "shebei-二次设备监视表")
public class SbSecondaryEquipmentMonitoringController {

    @Autowired
    private SbSecondaryEquipmentMonitoringService sbSecondaryEquipmentMonitoringService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<SbSecondaryEquipmentMonitoring> saveOrUpdate(@Valid @RequestBody SbSecondaryEquipmentMonitoring sbSecondaryEquipmentMonitoring){
        try {
            sbSecondaryEquipmentMonitoringService.saveOrUpdate(sbSecondaryEquipmentMonitoring);
            return  ResultUtil.data(sbSecondaryEquipmentMonitoring);
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
    public Result<Page<SbSecondaryEquipmentMonitoring>> list(PageVo pageVo, SbSecondaryEquipmentMonitoringQuery query) {
        QueryWrapper<SbSecondaryEquipmentMonitoring> queryWrapper = new QueryWrapper<SbSecondaryEquipmentMonitoring>() ;
        queryWrapper.lambda().eq(query.getSiteId()!=null, SbSecondaryEquipmentMonitoring::getSiteId,query.getSiteId());
        queryWrapper.lambda().eq(query.getDeviceType()!=null,SbSecondaryEquipmentMonitoring::getDeviceType,query.getDeviceType());
        queryWrapper.lambda().eq(query.getCabinetSelection()!=null,SbSecondaryEquipmentMonitoring::getCabinetSelection,query.getCabinetSelection());

        //TODO 条件待填写
        Page page = sbSecondaryEquipmentMonitoringService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             sbSecondaryEquipmentMonitoringService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<SbSecondaryEquipmentMonitoring> getById(BaseReqVO request) {
        try {
            SbSecondaryEquipmentMonitoring sbSecondaryEquipmentMonitoring = sbSecondaryEquipmentMonitoringService.getById(request.getId());
            return  ResultUtil.data(sbSecondaryEquipmentMonitoring);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

