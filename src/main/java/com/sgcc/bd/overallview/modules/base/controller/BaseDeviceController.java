package com.sgcc.bd.overallview.modules.base.controller;

import com.sgcc.bd.overallview.common.utils.ResultUtil;
import com.sgcc.bd.overallview.common.vo.InspectionPlanVO;
import com.sgcc.bd.overallview.modules.base.dto.AnFireDTO;
import com.sgcc.bd.overallview.modules.base.dto.DeviceCountDTO;
import com.sgcc.bd.overallview.modules.base.dto.DeviceMonitorDTO;
import com.sgcc.bd.overallview.modules.base.dto.InspectionPlanDTO;
import com.sgcc.bd.overallview.common.utils.PageUtil;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.common.vo.PageVo;
import com.sgcc.bd.overallview.common.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import com.sgcc.bd.overallview.modules.base.entity.BaseDevice;
import com.sgcc.bd.overallview.modules.base.query.BaseDeviceQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;
import com.sgcc.bd.overallview.modules.base.service.BaseDeviceService;

import java.util.List;

/**
 * @desc 主设备表 controller
 * @author chenfeixiang
 * @since 2021-06-08
 */
@RestController
@RequestMapping("/base/baseDevice")
@Slf4j
@ApiModel(value="BaseDevice对象", description="主设备表")
@Api(tags = "base-主设备表")
public class BaseDeviceController {

    @Autowired
    private BaseDeviceService baseDeviceService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<BaseDevice> saveOrUpdate(@Valid @RequestBody BaseDevice baseDevice){
        try {
            baseDeviceService.saveOrUpdate(baseDevice);
            return  ResultUtil.data(baseDevice);
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
    public Result<Page<BaseDevice>> list(PageVo pageVo, BaseDeviceQuery query) {
        QueryWrapper<BaseDevice> queryWrapper = new QueryWrapper<BaseDevice>() ;
        //TODO 条件待填写
        Page page = baseDeviceService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             baseDeviceService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<BaseDevice> getById(BaseReqVO request) {
        try {
            BaseDevice baseDevice = baseDeviceService.getById(request.getId());
            return  ResultUtil.data(baseDevice);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("查询所有的设备规模")
    @GetMapping("/getDeviceCount")
    public Result<List<DeviceCountDTO>> getDeviceCount(BaseReqVO request) {
        try {
            List<DeviceCountDTO> list = baseDeviceService.getDeviceCount(request);

            return  ResultUtil.data(list);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("查询所有的设备监视数量")
    @GetMapping("/getDeviceMonitorCount")
    public Result<DeviceMonitorDTO> getDeviceMonitorCount(BaseReqVO request) {
        try {
            DeviceMonitorDTO deviceCount = baseDeviceService.getDeviceMonitorCount(request);
            return  ResultUtil.data(deviceCount);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("安消防监视")
    @GetMapping("/getAnFireCount")
    public Result<AnFireDTO> getAnFireCount(BaseReqVO request) {
        try {
            AnFireDTO anFireCount = baseDeviceService.getAnFireCount(request);
            return  ResultUtil.data(anFireCount);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

 /*   @ApiOperation("环境监视")
    @GetMapping("/getEnvironmentalMonitoringCount")
    public Result<AnFireDTO> getEnvironmentalMonitoringCount(BaseReqVO request) {
        try {
            AnFireDTO anFireCount = baseDeviceService.getAnFireCount(request);
            return  ResultUtil.data(anFireCount);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }*/

    @ApiOperation("运检计划监视")
    @GetMapping("/getInspectionPlan")
    public Result<InspectionPlanDTO> getInspectionPlan(InspectionPlanVO request) {
        try {
            InspectionPlanDTO inspectionPlan = baseDeviceService.getInspectionPlan(request);
            return  ResultUtil.data(inspectionPlan);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

