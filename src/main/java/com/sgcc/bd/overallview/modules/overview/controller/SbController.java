package com.sgcc.bd.overallview.modules.overview.controller;

import cn.hutool.Hutool;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sgcc.bd.overallview.common.utils.PageUtil;
import com.sgcc.bd.overallview.common.utils.ResultUtil;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.common.vo.PageVo;
import com.sgcc.bd.overallview.common.vo.Result;
import com.sgcc.bd.overallview.modules.overview.dto.AlarmDTO;
import com.sgcc.bd.overallview.modules.overview.dto.GetCountDTO;
import com.sgcc.bd.overallview.modules.overview.dto.InformationAnalysisChartDTO;
import com.sgcc.bd.overallview.modules.overview.dto.LoadInformationDTO;
import com.sgcc.bd.overallview.modules.shebei.dto.SbDefectDTO;
import com.sgcc.bd.overallview.modules.shebei.entity.*;
import com.sgcc.bd.overallview.modules.shebei.query.SbBookQuery;
import com.sgcc.bd.overallview.modules.shebei.query.SbFuheQuery;
import com.sgcc.bd.overallview.modules.shebei.query.SbYousepuQuery;
import com.sgcc.bd.overallview.modules.shebei.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @desc 设备首页接口 controller
 * @author chenfeixiang
 * @since 2021-06-15
 */
@RestController
@RequestMapping("/shebei")
@Slf4j
@ApiModel(value="shebei", description="设备首页接口")
@Api(tags = "设备首页接口")
public class SbController {

    @Autowired
    private SbBookService sbBookService;
    @Autowired
    private SbAlarmService sbAlarmService;
    @Autowired
    private SbActiveWarningService sbActiveWarningService;
    @Autowired
    private SbFaultService sbFaultService;
    @Autowired
    private SbFuheService sbFuheService;
    @Autowired
    private SbYousepuService sbYousepuService;
    @Autowired
    private  SbRealdataService sbRealdataService;
    @Autowired
    private SbDefectService sbDefectService;
    @Autowired
    private SbDangerService sbDangerService;
    @Autowired
    private SbOverhaulService sbOverhaulService;

    @ApiOperation("监视告警")
    @GetMapping("/getAlarm")
    public Result<AlarmDTO> getAlarm(BaseReqVO request) {
        try {
            AlarmDTO alarmDTO = new AlarmDTO();

            QueryWrapper<SbAlarm> sbAlarmQueryWrapper = new QueryWrapper<>();
            sbAlarmQueryWrapper.lambda().eq(SbAlarm::getSiteId,request.getSiteId());
            sbAlarmQueryWrapper.lambda().eq(SbAlarm::getAlarmKind,1);
            List<SbAlarm> sbAlarms = sbAlarmService.getBaseMapper().selectList(sbAlarmQueryWrapper);
            int count = sbAlarmService.count(sbAlarmQueryWrapper);
            alarmDTO.setOnlineAlarmList(sbAlarms);
            alarmDTO.setOnlineAlarmNum(count);

            QueryWrapper<SbAlarm> sbAlarmQueryWrapper1 = new QueryWrapper<>();
            sbAlarmQueryWrapper1.lambda().eq(SbAlarm::getSiteId,request.getSiteId());
            sbAlarmQueryWrapper1.lambda().eq(SbAlarm::getAlarmKind,2);
            List<SbAlarm> monitoringAlarmList = sbAlarmService.getBaseMapper().selectList(sbAlarmQueryWrapper1);
            int monitoringAlarmNum = sbAlarmService.count(sbAlarmQueryWrapper1);
            alarmDTO.setMonitoringAlarmList(monitoringAlarmList);
            alarmDTO.setMonitoringAlarmNum(monitoringAlarmNum);

            QueryWrapper<SbActiveWarning> sbAlarmQueryWrapper2 = new QueryWrapper<>();
            sbAlarmQueryWrapper2.lambda().eq(SbActiveWarning::getSiteId,request.getSiteId());
            List<SbActiveWarning> sbActiveWarnings = sbActiveWarningService.getBaseMapper().selectList(sbAlarmQueryWrapper2);
            int count1 = sbActiveWarningService.count(sbAlarmQueryWrapper2);
            alarmDTO.setActiveWarning(sbActiveWarnings);
            alarmDTO.setActiveWarningNum(count1);

            QueryWrapper<SbFault> sbAlarmQueryWrapper3 = new QueryWrapper<>();
            sbAlarmQueryWrapper3.lambda().eq(SbFault::getSiteId,request.getSiteId());
            List<SbFault> sbFaultList = sbFaultService.getBaseMapper().selectList(sbAlarmQueryWrapper3);
            int count2 = sbActiveWarningService.count(sbAlarmQueryWrapper2);
            alarmDTO.setFaultList(sbFaultList);
            alarmDTO.setFaultNum(count2);

            QueryWrapper<SbFuhe> sbAlarmQueryWrapper4 = new QueryWrapper<>();
            sbAlarmQueryWrapper4.lambda().eq(SbFuhe::getSiteId,request.getSiteId());
            sbAlarmQueryWrapper4.lambda().eq(SbFuhe::getIsWeight,"是");
            List<SbFuhe> sbFuheList = sbFuheService.getBaseMapper().selectList(sbAlarmQueryWrapper4);
            int count3 = sbFuheService.count(sbAlarmQueryWrapper4);
            alarmDTO.setWeightList(sbFuheList);
            alarmDTO.setWeightNum(count3);

            return  ResultUtil.data(alarmDTO);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("油色谱列表")
    @GetMapping("/oilChromatographyList")
    public Result<List<SbYousepu>> oilChromatographyList(BaseReqVO request) {
        QueryWrapper<SbYousepu> queryWrapper = new QueryWrapper<SbYousepu>() ;
        //queryWrapper.lambda().like(query.getDeviceName()!=null,SbYousepu::getDeviceName,query.getDeviceName());
        queryWrapper.lambda().eq(SbYousepu::getSiteId,request.getSiteId());
        queryWrapper.lambda().gt(request.getStartTime()!= null , SbYousepu::getMonitoringTime,request.getStartTime());
        queryWrapper.lambda().lt(request.getEndTime() != null,SbYousepu::getMonitoringTime,request.getEndTime());
        //TODO 条件待填写
        List<SbYousepu> sbYousepus = sbYousepuService.getBaseMapper().selectList(queryWrapper);
        return ResultUtil.data(sbYousepus);
    }

    @ApiOperation("负荷信息列表")
    @GetMapping("/loadInformationList")
    public Result<LoadInformationDTO> loadInformationList(BaseReqVO request) {
        LoadInformationDTO loadInformationDTO = new  LoadInformationDTO();
        QueryWrapper<SbFuhe> queryWrapper = new QueryWrapper<SbFuhe>() ;
        //queryWrapper.lambda().like(query.getDeviceName()!=null,SbYousepu::getDeviceName,query.getDeviceName());
        queryWrapper.lambda().eq(SbFuhe::getSiteId,request.getSiteId());
        queryWrapper.lambda().eq(request.getId()!=null,SbFuhe::getId,request.getId());
        SbFuhe sbFuhe = sbFuheService.getBaseMapper().selectOne(queryWrapper);
        loadInformationDTO.setSbFuhe(sbFuhe);


        SbRealdata sbRealdata = sbRealdataService.getBaseMapper().selectOne(new QueryWrapper<SbRealdata>().lambda()
                .eq(SbRealdata::getSiteId, request.getSiteId())
                .eq(SbRealdata::getDeviceName, sbFuhe.getDeviceName())
        );
        loadInformationDTO.setSbRealdata(sbRealdata);
        return ResultUtil.data(loadInformationDTO);
    }

    @ApiOperation("负荷信息分析图")
    @GetMapping("/informationAnalysisChart")
    public Result<InformationAnalysisChartDTO> informationAnalysisChart(SbFuheQuery query) {
        InformationAnalysisChartDTO informationAnalysisChartDTO = new InformationAnalysisChartDTO();
        QueryWrapper<SbFuhe> queryWrapper = new QueryWrapper<SbFuhe>() ;
        //queryWrapper.lambda().like(query.getDeviceName()!=null,SbYousepu::getDeviceName,query.getDeviceName());
        queryWrapper.lambda().eq(SbFuhe::getSiteId,query.getSiteId());
        queryWrapper.lambda().eq(SbFuhe::getDeviceName,query.getDeviceName());

   /*     queryWrapper.lambda().gt(query.getStartTime()!= null , SbYousepu::getMonitoringTime,query.getStartTime());
        queryWrapper.lambda().lt(query.getEndTime() != null,SbYousepu::getMonitoringTime,query.getEndTime());*/
        //TODO 条件待填写
        List<SbFuhe> sbFuhes = sbFuheService.getBaseMapper().selectList(queryWrapper);
        informationAnalysisChartDTO.setSbFuhes(sbFuhes);

        queryWrapper.lambda().gt(SbFuhe::getMonitoringTime,DateUtil.lastMonth());
        queryWrapper.lambda().lt(SbFuhe::getMonitoringTime,new Date());
        queryWrapper.lambda().groupBy();
        SbFuhe sbFuhe = sbFuheService.getBaseMapper().selectOne(queryWrapper);
        informationAnalysisChartDTO.setDate(sbFuhe.getMonitoringTime());
        informationAnalysisChartDTO.setValues(sbFuhe.getLoadFactor());
        informationAnalysisChartDTO.setAccumulatedTime(sbFuhe.getAccumulatedTime());

        SbRealdata sbRealdata = sbRealdataService.getBaseMapper().selectOne(new QueryWrapper<SbRealdata>().lambda()
                .eq(SbRealdata::getSiteId, query.getSiteId())
                .eq(SbRealdata::getDeviceName, sbFuhe.getDeviceName())
        );

        List<Integer> nums = new ArrayList<Integer>();
        nums.add(sbRealdata.getAtopOilTemperatureOne());
        nums.add(sbRealdata.getBtopOilTemperatureOne());
        nums.add(sbRealdata.getCtopOilTemperatureOne());
        nums.add(sbRealdata.getAtopOilTemperatureTwo());
        nums.add(sbRealdata.getBtopOilTemperatureTwo());
        nums.add(sbRealdata.getCtopOilTemperatureTwo());
        //设置最大值Max
        int Max = Collections.max(nums);
        informationAnalysisChartDTO.setHighTemp(Max+"");
        return ResultUtil.data(informationAnalysisChartDTO);
    }


    @ApiOperation("缺陷隐患")
    @GetMapping("/getCountDefectNum")
    public Result<GetCountDTO> getCountDefectNum(BaseReqVO request) {
        try {
            GetCountDTO getCountDTO = new GetCountDTO();
            SbDefectDTO countDefectNum = sbDefectService.getCountDefectNum(request);
            SbDefectDTO countDangerNum = sbDangerService.getCountDangerNum(request);
            getCountDTO.setCountDefectNum(countDefectNum);
            getCountDTO.setCountDangerNum(countDangerNum);
            return  ResultUtil.data(getCountDTO);
            //todo 根据前端传过来的设备类型来查询 具体是什么设备的缺陷信息统计 这里是写死的 变压器，后面根据传过来的type进行修改。
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("设备大事记")
    @GetMapping("/getById")
    public Result<SbOverhaul> getById(BaseReqVO request) {
        try {
            //查一下设备检修记录的故障情况
            SbOverhaul sbOverhaul = sbOverhaulService.getBaseMapper().selectOne(new QueryWrapper<SbOverhaul>().lambda()
                    .eq(SbOverhaul::getSiteId,request.getSiteId())
                    .eq(SbOverhaul::getDeviceType,request.getType())
                    .groupBy(SbOverhaul::getWorkDate)
            );
            return  ResultUtil.data(sbOverhaul);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

}

