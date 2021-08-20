package com.sgcc.bd.overallview.modules.overview.controller;

import com.sgcc.bd.overallview.common.utils.ResultUtil;
import com.sgcc.bd.overallview.common.vo.InspectionPlanVO;
import com.sgcc.bd.overallview.common.vo.PageVo;
import com.sgcc.bd.overallview.modules.base.dto.DeviceCountDTO;
import com.sgcc.bd.overallview.modules.base.dto.DeviceMonitorDTO;
import com.sgcc.bd.overallview.modules.base.dto.InspectionPlanDTO;
import com.sgcc.bd.overallview.modules.job.entity.JobRepair;
import com.sgcc.bd.overallview.modules.job.entity.JobTicket;
import com.sgcc.bd.overallview.modules.job.query.JobTicketQuery;
import com.sgcc.bd.overallview.modules.job.service.JobRepairService;
import com.sgcc.bd.overallview.modules.job.service.JobTicketService;
import com.sgcc.bd.overallview.modules.overview.dto.*;
import com.sgcc.bd.overallview.modules.robot.entity.RobotInspMessage;
import com.sgcc.bd.overallview.modules.robot.query.RobotInspMessageQuery;
import com.sgcc.bd.overallview.modules.robot.service.RobotInspMessageService;
import com.sgcc.bd.overallview.modules.shebei.dto.SbDefectDTO;
import com.sgcc.bd.overallview.modules.shebei.query.SbHiddenDangersCountermeasuresQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sgcc.bd.overallview.common.utils.PageUtil;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.common.vo.Result;
import com.sgcc.bd.overallview.modules.base.entity.*;
import com.sgcc.bd.overallview.modules.base.service.*;
import com.sgcc.bd.overallview.modules.shebei.entity.*;
import com.sgcc.bd.overallview.modules.shebei.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description: 首页信息统计
 * @author: bbsn
 * @Time: 2021/7/14 15:35
 * @Params:
 */

@RestController
@RequestMapping("/overview")
@Slf4j
@ApiModel(value="overview", description="监视总览")
@Api(tags = "监视总览")
public class OverviewController {

    @Autowired
    private BaseOperationalRiskService baseOperationalRiskService;

    @Autowired
    private BaseSiteService baseSiteService;

    @Autowired
    private SbAlarmService sbAlarmService;

    @Autowired
    private SbActiveWarningService sbActiveWarningService;

    @Autowired
    private JobRepairService jobRepairService;

    @Autowired
    private SbDefectService sbDefectService;

    @Autowired
    private BaseMeteorologicalWarningService baseMeteorologicalWarningService;

    @Autowired
    private BasePowerProtectionService basePowerProtectionService;

    @Autowired
    private BaseInspectionRiskService baseInspectionRiskService;

    @Autowired
    private BaseRiskWarningService baseRiskWarningService;

    @Autowired
    private SbFaultService sbFaultService;

    @Autowired
    private BaseDeviceService baseDeviceService;

    @Autowired
    private JobTicketService jobTicketService;

    @Autowired
    private SbTestService sbTestService;

    @Autowired
    private SbLiveDetectionService sbLiveDetectionService;

    @Autowired
    private SbFeedService sbFeedService;

    @Autowired
    private RobotInspMessageService robotInspMessageService;

    @Autowired
    private SbHiddenDangersCountermeasuresService sbHiddenDangersCountermeasuresService;

    @Autowired
    private SbSparePartsListService sbSparePartsListService;

    @Autowired
    private  SbToolMonitoringService sbToolMonitoringService;


    @ApiOperation("获取单条变电站信息")
    @GetMapping("/getById")
    public Result<BaseSite> getById(BaseReqVO request) {
        try {
            BaseSite baseSite = baseSiteService.getById(request.getSiteId());
            return  ResultUtil.data(baseSite);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

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




            return  ResultUtil.data(alarmDTO);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }



    @ApiOperation("今日作业")
    @GetMapping("/getTodayWork")
    public Result<TodayWorkDTO> getTodayWork(BaseReqVO request) {
        try {
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//注意月份是MM
            Date day = new Date();
            String format = simpleDateFormat1.format(day);
            Date startTime = simpleDateFormat.parse(format + " " + "00:00:00");
            Date endTime = simpleDateFormat.parse(format + " " + "23:59:59");

            TodayWorkDTO todayWorkDTO = new TodayWorkDTO();
            QueryWrapper<JobRepair> jobRepairQueryWrapper = new QueryWrapper<>();
            jobRepairQueryWrapper.lambda().eq(JobRepair::getSiteId,request.getSiteId());
            jobRepairQueryWrapper.lambda().eq(JobRepair::getState,0);
            jobRepairQueryWrapper.lambda().gt(JobRepair::getBeginTime,startTime); //时间开始
            jobRepairQueryWrapper.lambda().lt(JobRepair::getBeginTime,endTime);//结束时间
            List<JobRepair> jobRepairs = jobRepairService.getBaseMapper().selectList(jobRepairQueryWrapper);
            int count = jobRepairService.count(jobRepairQueryWrapper);
            todayWorkDTO.setOverhaulList(jobRepairs);
            todayWorkDTO.setOverhaulNum(count);


            QueryWrapper<JobRepair> jobRepairQueryWrapper1 = new QueryWrapper<>();
            jobRepairQueryWrapper1.lambda().eq(JobRepair::getSiteId,request.getSiteId());
            jobRepairQueryWrapper1.lambda().eq(JobRepair::getState,1);
            jobRepairQueryWrapper1.lambda().gt(JobRepair::getBeginTime,startTime);
            jobRepairQueryWrapper1.lambda().lt(JobRepair::getBeginTime,endTime);

            List<JobRepair> jobRepairs1 = jobRepairService.getBaseMapper().selectList(jobRepairQueryWrapper1);
            int count1 = jobRepairService.count(jobRepairQueryWrapper1);
            todayWorkDTO.setOperationList(jobRepairs1);
            todayWorkDTO.setOperationNum(count1);


            QueryWrapper<JobRepair> jobRepairQueryWrapper2 = new QueryWrapper<>();
            jobRepairQueryWrapper2.lambda().eq(JobRepair::getSiteId,request.getSiteId());
            jobRepairQueryWrapper2.lambda().eq(JobRepair::getState,2);
            jobRepairQueryWrapper2.lambda().gt(JobRepair::getBeginTime,startTime);
            jobRepairQueryWrapper2.lambda().lt(JobRepair::getBeginTime,endTime);
            List<JobRepair> jobRepairs2 = jobRepairService.getBaseMapper().selectList(jobRepairQueryWrapper2);
            int count2 = jobRepairService.count(jobRepairQueryWrapper2);
            todayWorkDTO.setLineMaintenanceList(jobRepairs2);
            todayWorkDTO.setLineMaintenanceNum(count2);

            return  ResultUtil.data(todayWorkDTO);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }


    @ApiOperation("风险预警")
    @GetMapping("/getRiskAlarm")
    public Result<RiskAlarmDTO> getRiskAlarm(BaseReqVO request) {
        try {
            RiskAlarmDTO riskAlarmDTO = new RiskAlarmDTO();
            //气象预警第一条信息
            BaseMeteorologicalWarning baseMeteorologicalWarnings = baseMeteorologicalWarningService.getBaseMapper().selectOne(new QueryWrapper<BaseMeteorologicalWarning>().lambda()
                    .eq(BaseMeteorologicalWarning::getSiteId, request.getSiteId())
                    .last("limit 1")
                    .orderByDesc(BaseMeteorologicalWarning::getStartingTime));
            riskAlarmDTO.setBaseMeteorologicalWarning(baseMeteorologicalWarnings);
            //保电第一条信息
            BasePowerProtection basePowerProtection = basePowerProtectionService.getBaseMapper().selectOne(new QueryWrapper<BasePowerProtection>().lambda()
                    .eq(BasePowerProtection::getSiteId, request.getSiteId())
                    .last("limit 1")
                    .orderByDesc(BasePowerProtection::getStartTime));
            riskAlarmDTO.setBasePowerProtection(basePowerProtection);
            //巡视风险信息第一条
            BaseInspectionRisk baseInspectionRisk = baseInspectionRiskService.getBaseMapper().selectOne(new QueryWrapper<BaseInspectionRisk>().lambda()
                    .eq(BaseInspectionRisk::getSiteId, request.getSiteId())
                    .last("limit 1")
                    .orderByDesc(BaseInspectionRisk::getEndTime)
            );
            riskAlarmDTO.setBaseInspectionRisk(baseInspectionRisk);
            //风险预警第一条
            BaseRiskWarning baseRiskWarning = baseRiskWarningService.getBaseMapper().selectOne(new QueryWrapper<BaseRiskWarning>().lambda()
                    .eq(BaseRiskWarning::getSiteId, request.getSiteId())
                    .last("limit 1")
                    .orderByDesc(BaseRiskWarning::getDatee)
            );
            riskAlarmDTO.setBaseRiskWarning(baseRiskWarning);
            return  ResultUtil.data(riskAlarmDTO);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("故障跳闸监视")
    @GetMapping("/getDefault")
    public Result<SbFault> getDefault(BaseReqVO request) {
        try {
            SbFault sbFault = sbFaultService.getBaseMapper().selectOne(new QueryWrapper<SbFault>().lambda().eq(SbFault::getSiteId, request.getSiteId())
                    .orderByDesc(SbFault::getBreakdownTime)
            );
            return  ResultUtil.data(sbFault);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("检修计划监视")
    @GetMapping("/getInspectionPlan")
    public Result<InspectionPlanDTO> getInspectionPlan(InspectionPlanVO request) {
        try {
            InspectionPlanDTO inspectionPlan = baseDeviceService.getInspectionPlan(request);
            return  ResultUtil.data(inspectionPlan);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("作业监视")
    @GetMapping("/workList")
    public Result<Page<JobTicket>> workList(PageVo pageVo, JobTicketQuery query) {
        QueryWrapper<JobTicket> queryWrapper = new QueryWrapper<JobTicket>() ;
        queryWrapper.lambda().eq(JobTicket::getSiteId,query.getSiteId());
        queryWrapper.lambda().like(query.getTicketNumber()!=null,JobTicket::getTicketNumber,query.getTicketNumber());
        queryWrapper.lambda().eq(query.getTicketType()!=null,JobTicket::getTicketType,query.getTicketType());
        queryWrapper.lambda().like(query.getTicketOrgname()!=null,JobTicket::getTicketOrgname,query.getTicketOrgname());
        queryWrapper.lambda().like(query.getTicketPerson()!=null,JobTicket::getTicketPerson,query.getTicketPerson());
        queryWrapper.lambda().like(query.getPermitPersion()!=null,JobTicket::getPermitPersion,query.getPermitPersion());
        queryWrapper.lambda().gt(query.getStartTime()!= null ,JobTicket::getTicketPlanTime,query.getStartTime());
        queryWrapper.lambda().lt(query.getEndTime() != null,JobTicket::getTicketPlanTime,query.getEndTime());
        //TODO 条件待填写
        Page page = jobTicketService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("设备监视")
    @GetMapping("/getDeviceMonitorCount")
    public Result<DeviceMonitorDTO> getDeviceMonitorCount(BaseReqVO request) {
        try {
            DeviceMonitorDTO deviceCount = baseDeviceService.getDeviceMonitorCount(request);
            return  ResultUtil.data(deviceCount);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("设备规模")
    @GetMapping("/getDeviceCount")
    public Result<List<DeviceCountDTO>> getDeviceCount(BaseReqVO request) {
        try {
            List<DeviceCountDTO> list = baseDeviceService.getDeviceCount(request);
            return  ResultUtil.data(list);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("异常信息")
    @GetMapping("/getAbnormalCount")
    public Result<AbnormalCountDTO> getAbnormalCount(BaseReqVO request) {
        try {
            AbnormalCountDTO abnormalCountDTO = new AbnormalCountDTO();
          //  List<DeviceCountDTO> list = baseDeviceService.getDeviceCount(request);
            //todo 健康趋势异常 跟寿命下降异常数据还不知道从哪拿。。

            int experimentAbnormalNum = sbTestService.count(new QueryWrapper<SbTest>().lambda()
                    .eq(SbTest::getSiteId, request.getSiteId())
                    .eq(SbTest::getTestConclusion, "异常")
            );
            abnormalCountDTO.setExperimentAbnormalNum(experimentAbnormalNum);
            int chargeDetectionNum = sbLiveDetectionService.count(new QueryWrapper<SbLiveDetection>().lambda()
                    .eq(SbLiveDetection::getSiteId, request.getSiteId())
                    .eq(SbLiveDetection::getConclusion, "异常")
            );
            abnormalCountDTO.setChargeDetectionNum(chargeDetectionNum);
            int abnormalStatusNum = sbFeedService.count(new QueryWrapper<SbFeed>().lambda().eq(SbFeed::getSiteId, request.getSiteId())
                    .eq(SbFeed::getEvaluationConclusion, "异常")
            );
            abnormalCountDTO.setAbnormalStatusNum(abnormalStatusNum);
           int  seriousStatusNum = sbFeedService.count(new QueryWrapper<SbFeed>().lambda().eq(SbFeed::getSiteId, request.getSiteId())
                   .eq(SbFeed::getEvaluationConclusion, "严重")
           );
            abnormalCountDTO.setSeriousStatusNum(seriousStatusNum);
            return  ResultUtil.data(abnormalCountDTO);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("智能巡视监视")
    @GetMapping("/getRobotTaskList")
    public Result<Page<RobotInspMessage>> getRobotTaskList(PageVo pageVo, RobotInspMessageQuery query) {
        QueryWrapper<RobotInspMessage> queryWrapper = new QueryWrapper<RobotInspMessage>() ;
        queryWrapper.lambda().eq(RobotInspMessage::getSiteId,query.getSiteId());
        queryWrapper.lambda().like(query.getInspName()!=null,RobotInspMessage::getInspName,query.getInspName());
        queryWrapper.lambda().like(query.getRobotName()!=null,RobotInspMessage::getRobotName,query.getRobotName());
        queryWrapper.lambda().like(query.getInspPoints()!=null,RobotInspMessage::getInspPoints,query.getInspPoints());
        queryWrapper.lambda().like(query.getInspType()!=null,RobotInspMessage::getInspType,query.getInspType());
        queryWrapper.lambda().like(query.getInspResult()!=null,RobotInspMessage::getInspResult,query.getInspResult());
        queryWrapper.lambda().eq(query.getAlarmLevel()!=null,RobotInspMessage::getAlarmLevel,query.getAlarmLevel());
        queryWrapper.lambda().gt(query.getStartTime()!= null ,RobotInspMessage::getInspTime,query.getStartTime()); //时间开始
        queryWrapper.lambda().lt(query.getEndTime() != null,RobotInspMessage::getInspTime,query.getEndTime());//结束时间
        //TODO 条件待填写
        Page page = robotInspMessageService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("设备健康状况")
    @GetMapping("/equipmentHealth")
    public Result<EquipmentHealthDTO> equipmentHealth(BaseReqVO request) {
        try {
            EquipmentHealthDTO equipmentHealthDTO = new EquipmentHealthDTO();
            //设备总数
            int totalNum = baseDeviceService.count(new QueryWrapper<BaseDevice>().lambda().eq(BaseDevice::getSiteId, request.getSiteId()));
            equipmentHealthDTO.setTotalNum(totalNum);
            //健康
            int healthNum  = baseDeviceService.count(new QueryWrapper<BaseDevice>().lambda()
                    .eq(BaseDevice::getSiteId, request.getSiteId())
                    .eq(BaseDevice::getDeviceState, 0)
            );
            equipmentHealthDTO.setHealthNum(healthNum);
            //亚健康
            int subhealthNum  = baseDeviceService.count(new QueryWrapper<BaseDevice>().lambda()
                    .eq(BaseDevice::getSiteId, request.getSiteId())
                    .eq(BaseDevice::getDeviceState, 1)
            );
            equipmentHealthDTO.setSubhealthNum(subhealthNum);
            //注意
            int noteNum  = baseDeviceService.count(new QueryWrapper<BaseDevice>().lambda()
                    .eq(BaseDevice::getSiteId, request.getSiteId())
                    .eq(BaseDevice::getDeviceState, 2)
            );
            equipmentHealthDTO.setNoteNum(noteNum);
            //异常
            int abnormalNum  = baseDeviceService.count(new QueryWrapper<BaseDevice>().lambda()
                    .eq(BaseDevice::getSiteId, request.getSiteId())
                    .eq(BaseDevice::getDeviceState, 3));
            equipmentHealthDTO.setAbnormalNum(abnormalNum);
            //严重
            int seriousNum  = baseDeviceService.count(new QueryWrapper<BaseDevice>().lambda()
                    .eq(BaseDevice::getSiteId, request.getSiteId())
                    .eq(BaseDevice::getDeviceState, 4));
            equipmentHealthDTO.setSeriousNum(seriousNum);
            return  ResultUtil.data(equipmentHealthDTO);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("隐患反措专项排查")
    @GetMapping("/specialInvestigation")
    public Result<Page<SbHiddenDangersCountermeasures>> specialInvestigation(PageVo pageVo, SbHiddenDangersCountermeasuresQuery query) {
        QueryWrapper<SbHiddenDangersCountermeasures> queryWrapper = new QueryWrapper<SbHiddenDangersCountermeasures>() ;
        queryWrapper.lambda().eq(SbHiddenDangersCountermeasures::getSiteId,query.getSiteId());
        //TODO 条件待填写
        Page page = sbHiddenDangersCountermeasuresService.page(PageUtil.initMpPage(pageVo),queryWrapper);
        return ResultUtil.data(page);
    }

    @ApiOperation("备品备件监视")
    @GetMapping("/sparePartsMonitoring")
    public Result<List<DeviceCountDTO>> sparePartsMonitoring(BaseReqVO request) {
        try {
            List<DeviceCountDTO> list = baseDeviceService.sparePartsMonitoring(request);
            return  ResultUtil.data(list);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("工器具监视")
    @GetMapping("/toolMonitoring")
    public Result<List<DeviceCountDTO>> toolMonitoring(BaseReqVO request) {
        try {
            List<DeviceCountDTO> list = baseDeviceService.toolMonitoring(request);
            return  ResultUtil.data(list);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("二次设备监视")
    @GetMapping("/secondaryEquipment")
    public Result<List<DeviceCountDTO>> secondaryEquipment(BaseReqVO request) {
        try {
            List<DeviceCountDTO> list = baseDeviceService.secondaryEquipment(request);
            return  ResultUtil.data(list);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("运维绩效管理")
    @GetMapping("/performanceManagement")
    public Result<List<DeviceCountDTO>> performanceManagement(BaseReqVO request) {
        try {
            List<DeviceCountDTO> list = baseDeviceService.performanceManagement(request);
            return  ResultUtil.data(list);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }


    @ApiOperation("计划辅助决策")
    @GetMapping("/planAssistDecision")
    public Result<List<DeviceCountDTO>> planAssistDecision(BaseReqVO request) {
        try {
            //todo 计划辅助决策部分它们还在商榷中
            List<DeviceCountDTO> list = baseDeviceService.secondaryEquipment(request);
            return  ResultUtil.data(list);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @ApiOperation("工器具到期时间")
    @GetMapping("/toolExpiryTime")
    public Result<List<SbToolMonitoring>> toolExpiryTime(BaseReqVO request) {
        try {
            List<SbToolMonitoring> sbToolMonitorings = sbToolMonitoringService.getBaseMapper().selectList(new QueryWrapper<SbToolMonitoring>().lambda()
                    .eq(SbToolMonitoring::getSiteId, request.getSiteId())
            );
            int oneDay = 24*60*60*1000;
            List<SbToolMonitoring> newSbToolMonitoring = new ArrayList<>();
            sbToolMonitorings.forEach(sbToolMonitoring -> {
                //非空判断
                if(sbToolMonitoring.getTestCycle()!=null&&sbToolMonitoring.getLastTestDate()!=null){
                    Long time =   System.currentTimeMillis() - sbToolMonitoring.getTestCycle()*oneDay*30 -  sbToolMonitoring.getLastTestDate().getTime();
                    if (time<= oneDay*7&&time>0){
                        Long day =   (oneDay*7-time)/oneDay ;
                        //延迟天数
                        sbToolMonitoring.setDay(day);
                        //1状态表示即将到期
                        sbToolMonitoring.setIsOverdue("1");
                        newSbToolMonitoring.add(sbToolMonitoring);
                    }else if (time<0){
                        //2表示已超期
                        sbToolMonitoring.setIsOverdue("2");
                        newSbToolMonitoring.add(sbToolMonitoring);
                    }
                }
            });
            return  ResultUtil.data(newSbToolMonitoring);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }


}

