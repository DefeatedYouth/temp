package com.sgcc.bd.overallview.modules.overview.controller;


import com.sgcc.bd.overallview.common.utils.ResultUtil;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.common.vo.Result;
import com.sgcc.bd.overallview.modules.anxiaofang.dto.*;
import com.sgcc.bd.overallview.modules.anxiaofang.service.AxfDeviceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @desc 安消防首页列表信息 controller
 * @author chenfeixiang
 * @since 2021-06-08
 */
@RestController
@RequestMapping("/anxiaofang")
@Slf4j
@ApiModel(value="Axf对象", description="安消防首页")
@Api(tags = "安消防首页列表信息")
public class AxfController {

    @Autowired
    private AxfDeviceService axfDeviceService;


    @ApiOperation("消防设施信息总览")
    @GetMapping("/fireFightingOvweview")
    public Result<FirefightovweviewDTO> fireFightingOvweview(BaseReqVO request) {
        try {
            //todo 消防设施信息总览 先默认从那边直接取过来 智能锁具信息监测  钥匙箱信息监视 这部分的信息先前端写死
            FirefightovweviewDTO firefightovweviewDTO = axfDeviceService.fireFightingOvweview(request);
            return  ResultUtil.data(firefightovweviewDTO);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("红外对射信息监视")
    @GetMapping("/infraredRadiationCount")
    public Result<InfraredRadiationCountDTO> infraredRadiationCount(BaseReqVO request){
        try {
            InfraredRadiationCountDTO infraredRadiationCountDTO = axfDeviceService.infraredRadiationCount(request);
            return  ResultUtil.data(infraredRadiationCountDTO);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("红外双鉴信息监视")
    @GetMapping("/infraredDoubleDetector")
    public Result<InfraredRadiationCountDTO>   infraredDoubleDetector(BaseReqVO request){
        try {
            InfraredRadiationCountDTO infraredRadiationCountDTO = axfDeviceService.infraredDoubleDetector(request);
            return  ResultUtil.data(infraredRadiationCountDTO);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("摄像头信息")
    @GetMapping("/cameraInfoCount")
    public Result<InfraredRadiationCountDTO>   cameraInfoCount(BaseReqVO request){
        try {
            InfraredRadiationCountDTO infraredRadiationCountDTO = axfDeviceService.cameraInfoCount(request);
            return  ResultUtil.data(infraredRadiationCountDTO);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }


    @ApiOperation("电子围栏信息监视")
    @GetMapping("/electronicFenceNum")
    public Result<ElectronicFenceDTO>   electronicFenceNum(BaseReqVO request){
        try {
            ElectronicFenceDTO electronicFenceDTO = axfDeviceService.electronicFenceNum(request);
            return  ResultUtil.data(electronicFenceDTO);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }


    @ApiOperation("门禁信息监视")
    @GetMapping("/accessControlInformation")
    public Result<AccessControlInformationDTO>   accessControlInformation(BaseReqVO request){
        try {
            AccessControlInformationDTO electronicFenceDTO = axfDeviceService.accessControlInformation(request);
            return  ResultUtil.data(electronicFenceDTO);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }



}

