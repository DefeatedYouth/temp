package com.sgcc.bd.overallview.modules.overview.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sgcc.bd.overallview.common.utils.PageUtil;
import com.sgcc.bd.overallview.common.utils.ResultUtil;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.common.vo.PageVo;
import com.sgcc.bd.overallview.common.vo.Result;
import com.sgcc.bd.overallview.modules.base.entity.BaseSite;
import com.sgcc.bd.overallview.modules.base.service.BaseSiteService;
import com.sgcc.bd.overallview.modules.huanjing.dto.HjEquipmentNumDTO;
import com.sgcc.bd.overallview.modules.huanjing.dto.HjWenduDTO;
import com.sgcc.bd.overallview.modules.huanjing.entity.HjChushiji;
import com.sgcc.bd.overallview.modules.huanjing.query.HjChushijiQuery;
import com.sgcc.bd.overallview.modules.huanjing.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @description: TODO
 * @author: bbsn
 * @Time: 2021/7/14 15:34
 * @Params:
 */
@RestController
@RequestMapping("/movingring")
@Slf4j
@ApiModel(value="动环信息列表页", description="")
@Api(tags = "动环信息列表页")
public class MovingRingController {

    @Autowired
    private HjChushijiService hjChushijiService;

    @Autowired
    private BaseSiteService baseSiteService;

    @Autowired
    private HjWenduService hjWenduService;

    @Autowired
    private HjShiduService hjShiduService;

    @Autowired
    private HjDengguangService hjDengguangService;

    @Autowired
    private HjKongtiaoService hjKongtiaoService;

    @Autowired
    private HjSfsexService hjSfsexService;

    @Autowired
    private HjFengjiService hjFengjiService;

    @Autowired
    private HjShuibangService hjShuibangService;

    @Autowired
    private HjShuishengService hjShuishengService;

    @Autowired
    private HjShuiweiService hjShuiweiService;


    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("获取变电站信息")
    @GetMapping("/getSiteDetail")
    public Result<BaseSite> getSiteDetail(BaseReqVO request) {
        try {
            BaseSite baseSite = baseSiteService.getById(request.getId());
            return  ResultUtil.data(baseSite);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation(value = "温度首页统计",notes = "参数 变电站id")
    @GetMapping("/temperatureCount")
    public Result<HjWenduDTO> temperatureCount(BaseReqVO request) {
        try {
            HjWenduDTO hjWenduDTO = hjWenduService.temperatureCount(request);
            return  ResultUtil.data(hjWenduDTO);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation(value = "湿度首页统计",notes = "参数 变电站id")
    @GetMapping("/humidityCount")
    public Result<HjWenduDTO> humidityCount(BaseReqVO request) {
        try {
            HjWenduDTO hjWenduDTO = hjShiduService.temperatureCount(request);
            return  ResultUtil.data(hjWenduDTO);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation(value = "灯光设备监视数量统计",notes = "参数 变电站id")
    @GetMapping("/getLightEquipmentNum")
    public Result<HjEquipmentNumDTO> getLightEquipmentNum(BaseReqVO request) {
        try {
            HjEquipmentNumDTO auxiliaryEquipmentNum = hjDengguangService.getAuxiliaryEquipmentNum(request);
            return  ResultUtil.data(auxiliaryEquipmentNum);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation(value = "除湿机设备监视数量统计",notes = "参数 变电站id")
    @GetMapping("/getAuxiliaryEquipmentNum")
    public Result<HjEquipmentNumDTO> getAuxiliaryEquipmentNum(BaseReqVO request) {
        try {
            HjEquipmentNumDTO auxiliaryEquipmentNum = hjChushijiService.getAuxiliaryEquipmentNum(request);
            return  ResultUtil.data(auxiliaryEquipmentNum);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation(value = "空调设备监视数量统计",notes = "参数 变电站id")
    @GetMapping("/getAirConditioningEquipmentNum")
    public Result<HjEquipmentNumDTO> getAirConditioningEquipmentNum(BaseReqVO request) {
        try {
            HjEquipmentNumDTO auxiliaryEquipmentNum = hjKongtiaoService.getAuxiliaryEquipmentNum(request);
            return  ResultUtil.data(auxiliaryEquipmentNum);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation(value = "风机设备监视数量统计",notes = "参数 变电站id")
    @GetMapping("/getFanEquipmentNum")
    public Result<HjEquipmentNumDTO> getFanEquipmentNum(BaseReqVO request) {
        try {
            HjEquipmentNumDTO auxiliaryEquipmentNum = hjFengjiService.getAuxiliaryEquipmentNum(request);
            return  ResultUtil.data(auxiliaryEquipmentNum);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation(value = "SF6设备监视数量统计",notes = "参数 变电站id")
    @GetMapping("/getSF6EquipmentNum")
    public Result<HjEquipmentNumDTO> getSF6EquipmentNum(BaseReqVO request) {
        try {
            HjEquipmentNumDTO auxiliaryEquipmentNum = hjSfsexService.getAuxiliaryEquipmentNum(request);
            return  ResultUtil.data(auxiliaryEquipmentNum);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation(value = "水泵设备监视数量统计",notes = "参数 变电站id")
    @GetMapping("/getWaterPumpEquipmentNum")
    public Result<HjEquipmentNumDTO> getWaterPumpEquipmentNum(BaseReqVO request) {
        try {
            HjEquipmentNumDTO auxiliaryEquipmentNum = hjShuibangService.getAuxiliaryEquipmentNum(request);
            return  ResultUtil.data(auxiliaryEquipmentNum);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation(value = "水深设备监视数量统计",notes = "参数 变电站id")
    @GetMapping("/getWaterDepthEquipmentNum")
    public Result<HjEquipmentNumDTO> getWaterDepthEquipmentNum(BaseReqVO request) {
        try {
            HjEquipmentNumDTO auxiliaryEquipmentNum = hjShuishengService.getAuxiliaryEquipmentNum(request);
            return  ResultUtil.data(auxiliaryEquipmentNum);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation(value = "水位设备监视数量统计",notes = "参数 变电站id")
    @GetMapping("/getWaterLevelEquipmentNum")
    public Result<HjEquipmentNumDTO> getWaterLevelEquipmentNum(BaseReqVO request) {
        try {
            HjEquipmentNumDTO auxiliaryEquipmentNum = hjShuiweiService.getAuxiliaryEquipmentNum(request);
            return  ResultUtil.data(auxiliaryEquipmentNum);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

