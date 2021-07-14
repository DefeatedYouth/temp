package com.sgcc.bd.overallview.modules.shebei.controller;

import com.sgcc.bd.overallview.common.enums.EnumAlarmStateType;
import com.sgcc.bd.overallview.common.enums.EnumAlarmType;
import com.sgcc.bd.overallview.common.enums.EnumDeviceType;
import com.sgcc.bd.overallview.common.utils.PageUtil;
import com.sgcc.bd.overallview.common.utils.ResultUtil;
import com.sgcc.bd.overallview.modules.shebei.dto.SbAlarmNumDTO;
import com.sgcc.bd.overallview.common.vo.PageVo;
import com.sgcc.bd.overallview.common.vo.Result;
import com.sgcc.bd.overallview.modules.shebei.service.SbAlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.modules.shebei.entity.SbAlarm;
import com.sgcc.bd.overallview.modules.shebei.query.SbAlarmQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;

/**
 * @desc 断路器告警数据表 controller
 * @author chenfeixiang
 * @since 2021-06-15
 */
@RestController
@RequestMapping("/shebei/sbAlarm")
@Slf4j
@ApiModel(value="SbAlarm对象", description="断路器告警数据表")
@Api(tags = "shebei-断路器告警数据表")
public class SbAlarmController {

    @Autowired
    private SbAlarmService sbAlarmService;

    /**
     * @desc 新增或更新,带id为修改，不带id为新增
     */
    @ApiOperation("新增或更新")
    @PostMapping("/saveOrUpdate")
    public Result<SbAlarm> saveOrUpdate(@Valid @RequestBody SbAlarm sbAlarm){
        try {
            sbAlarmService.saveOrUpdate(sbAlarm);
            return  ResultUtil.data(sbAlarm);
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
    public Result<Page<SbAlarm>> list(PageVo pageVo, SbAlarmQuery query) {
        QueryWrapper<SbAlarm> queryWrapper = new QueryWrapper<SbAlarm>() ;
        queryWrapper.lambda().eq(SbAlarm::getSiteId,query.getSiteId());
        queryWrapper.lambda().like(query.getPlaceName()!=null,SbAlarm::getPlaceName,query.getPlaceName());
        //queryWrapper.lambda().like(query.getSiteName()!=null,SbAlarm::getSiteName,query.getSiteName());
        queryWrapper.lambda().eq(query.getDeviceType()!=null, SbAlarm::getDeviceType, EnumDeviceType.valueOf(query.getDeviceType()));
        queryWrapper.lambda().like(query.getDeviceName()!=null,SbAlarm::getDeviceName,query.getDeviceName());
        queryWrapper.lambda().eq(query.getAlarmType()!=null,SbAlarm::getAlarmType,EnumAlarmType.valueOf(query.getAlarmType()));
        queryWrapper.lambda().like(query.getAlarmDesc()!=null,SbAlarm::getAlarmDesc,query.getAlarmDesc());
        queryWrapper.lambda().eq(query.getAlarmState()!=null,SbAlarm::getAlarmState,EnumAlarmStateType.valueOf(query.getAlarmState()));

        //TODO 条件待填写
        Page page = sbAlarmService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("批量删除")
    @PostMapping("/remove")
    public Result remove(@RequestBody BaseReqVO request){
        try {
             sbAlarmService.removeByIds(request.getIds());
            return  ResultUtil.success(null);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("单条记录查询")
    @GetMapping("/getById")
    public Result<SbAlarm> getById(BaseReqVO request) {
        try {
            SbAlarm sbAlarm = sbAlarmService.getById(request.getId());
            return  ResultUtil.data(sbAlarm);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("查询设备事故告警数量，未处理告警数量")
    @GetMapping("/getAlarmNum")
    public Result<SbAlarmNumDTO> getAlarmNum(BaseReqVO request) {
        try {
            SbAlarmNumDTO alarmNum = sbAlarmService.getAlarmNum(request);
            return  ResultUtil.data(alarmNum);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }
}

