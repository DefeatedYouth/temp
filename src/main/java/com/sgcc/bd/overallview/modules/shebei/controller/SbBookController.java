package com.sgcc.bd.overallview.modules.shebei.controller;

import com.sgcc.bd.overallview.common.utils.PageUtil;
import com.sgcc.bd.overallview.common.utils.ResultUtil;
import com.sgcc.bd.overallview.common.vo.PageVo;
import com.sgcc.bd.overallview.common.vo.Result;
import com.sgcc.bd.overallview.modules.shebei.entity.SbBook;
import com.sgcc.bd.overallview.modules.shebei.query.SbBookQuery;
import com.sgcc.bd.overallview.modules.shebei.service.SbBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @desc 断路器设备台账 controller
 * @author chenfeixiang
 * @since 2021-06-15
 */
@RestController
@RequestMapping("/shebei/sbBook")
@Slf4j
@ApiModel(value="SbBook对象", description="断路器设备台账")
@Api(tags = "shebei-断路器设备台账")
public class SbBookController {

    @Autowired
    private SbBookService sbBookService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<SbBook> saveOrUpdate(@Valid @RequestBody SbBook sbBook){
        try {
            sbBookService.saveOrUpdate(sbBook);
            return  ResultUtil.data(sbBook);
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
    public Result<Page<SbBook>> list(PageVo pageVo, SbBookQuery query) {
        QueryWrapper<SbBook> queryWrapper = new QueryWrapper<>();
        //TODO 条件待填写
        queryWrapper.lambda().eq(query.getSiteId()!= null,SbBook::getSiteId,query.getSiteId());
        queryWrapper.lambda().eq(query.getDeviceType()!= null,SbBook::getDeviceType,query.getDeviceType());
        queryWrapper.lambda().like(query.getDeviceName()!= null,SbBook::getDeviceName,query.getDeviceName());
        queryWrapper.lambda().eq(query.getManufacturer()!= null,SbBook::getManufacturer,query.getManufacturer());
        queryWrapper.lambda().eq(query.getVoltageLevel()!= null,SbBook::getVoltageLevel,query.getVoltageLevel());
        queryWrapper.lambda().eq(query.getEquipmentModel()!= null,SbBook::getEquipmentModel,query.getEquipmentModel());
        queryWrapper.lambda().gt(query.getStartTime()!= null ,SbBook::getUseTime,query.getStartTime());
        queryWrapper.lambda().lt(query.getEndTime() != null,SbBook::getUseTime,query.getEndTime());
        Page page = sbBookService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("厂家列表")
    @GetMapping("/manufacturerList")
    public Result<List<SbBook>> manufacturerList(SbBookQuery query) {
        QueryWrapper<SbBook> queryWrapper = new QueryWrapper<>() ;
        queryWrapper.lambda().eq(query.getSiteId()!= null,SbBook::getSiteId,query.getSiteId());
        queryWrapper.lambda().isNotNull(SbBook::getManufacturer);
        queryWrapper.lambda().eq(query.getDeviceType()!= null,SbBook::getDeviceType,query.getDeviceType());
        queryWrapper.lambda().groupBy(SbBook::getManufacturer);
        queryWrapper.lambda().select(SbBook::getManufacturer);
        List<SbBook> list = sbBookService.list(queryWrapper);
        return ResultUtil.data(list);
    }
    @ApiOperation("电压等级列表")
    @GetMapping("/voltageLevelList")
    public Result<List<SbBook>> voltageLevelList(SbBookQuery query) {
        QueryWrapper<SbBook> queryWrapper = new QueryWrapper<>() ;
        queryWrapper.lambda().isNotNull(SbBook::getVoltageLevel);
        queryWrapper.lambda().eq(query.getSiteId()!= null,SbBook::getSiteId,query.getSiteId());
        queryWrapper.lambda().eq(query.getDeviceType()!= null,SbBook::getDeviceType,query.getDeviceType());
        queryWrapper.lambda().groupBy(SbBook::getVoltageLevel);
        queryWrapper.lambda().select(SbBook::getVoltageLevel);
        List<SbBook> list = sbBookService.list(queryWrapper);
        return ResultUtil.data(list);
    }
    @ApiOperation("设备型号列表")
    @GetMapping("/equipmentModelList")
    public Result<List<SbBook>> equipmentModelList(SbBookQuery query) {
        QueryWrapper<SbBook> queryWrapper = new QueryWrapper<>() ;
        queryWrapper.lambda().isNotNull(SbBook::getEquipmentModel);
        queryWrapper.lambda().eq(query.getSiteId()!= null,SbBook::getSiteId,query.getSiteId());
        queryWrapper.lambda().eq(query.getDeviceType()!= null,SbBook::getDeviceType,query.getDeviceType());
        queryWrapper.lambda().groupBy(SbBook::getEquipmentModel);
        queryWrapper.lambda().select(SbBook::getEquipmentModel);
        List<SbBook> list = sbBookService.list(queryWrapper);
        return ResultUtil.data(list);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             sbBookService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<SbBook> getById(BaseReqVO request) {
        try {
            SbBook sbBook = sbBookService.getById(request.getId());
            return  ResultUtil.data(sbBook);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

