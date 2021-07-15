package com.sgcc.bd.overallview.modules.base.service.impl;


import com.sgcc.bd.overallview.common.enums.*;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.common.vo.InspectionPlanVO;
import com.sgcc.bd.overallview.modules.anxiaofang.entity.AxfDevice;
import com.sgcc.bd.overallview.modules.anxiaofang.service.AxfDeviceService;
import com.sgcc.bd.overallview.modules.base.dto.AnFireDTO;
import com.sgcc.bd.overallview.modules.base.dto.DeviceCountDTO;
import com.sgcc.bd.overallview.modules.base.dto.DeviceMonitorDTO;
import com.sgcc.bd.overallview.modules.base.dto.InspectionPlanDTO;
import com.sgcc.bd.overallview.modules.base.service.BaseDeviceService;
import com.sgcc.bd.overallview.modules.job.entity.*;
import com.sgcc.bd.overallview.modules.job.service.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sgcc.bd.overallview.modules.shebei.entity.*;
import com.sgcc.bd.overallview.modules.shebei.service.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sgcc.bd.overallview.modules.base.entity.BaseDevice;
import com.sgcc.bd.overallview.modules.base.dao.BaseDeviceDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @desc 主设备表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class BaseDeviceServiceImpl extends ServiceImpl<BaseDeviceDao, BaseDevice> implements BaseDeviceService {

    @Autowired
    BaseDeviceDao baseDeviceDao;
    @Autowired
    SbBookService sbBookService;
    @Autowired
    SbDefectService sbDefectService;
    @Autowired
    SbDangerService sbDangerService;
    @Autowired
    SbAlarmService sbAlarmService;
    @Autowired
    SbFaultService sbFaultService;
    @Autowired
    AxfDeviceService axfDeviceService;
    @Autowired
    JobRepairService jobRepairService;
    @Autowired
    SbSparePartsListService sbSparePartsListService;
    @Autowired
    SbToolMonitoringService sbToolMonitoringService;
    @Autowired
    SbSecondaryEquipmentMonitoringService sbSecondaryEquipmentMonitoringService;
    @Autowired
    JobTicketService jobTicketService;
    @Autowired
    JobOperationTicketService jobOperationTicketService;
    @Autowired
    JobMaintenanceWorkService jobMaintenanceWorkService;

    @Autowired
    JobPatrolTaskService jobPatrolTaskService;

    @Override
    public List<DeviceCountDTO> getDeviceCount(BaseReqVO request) {
        List<DeviceCountDTO> list = new ArrayList<>();
        initDeviceCountList(list);
        QueryWrapper<SbBook> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(request.getSiteId() != null,SbBook::getSiteId, request.getSiteId())
                .groupBy(SbBook::getDeviceType);
        queryWrapper.select("device_type,count(*) num");
        List<Map<String, Object>> maps = sbBookService.listMaps(queryWrapper);
        for (Map<String, Object> map : maps) {
            if (map.get("device_type") != null && map.get("num") != null ){
                Integer deviceType = (Integer)map.get("device_type");
                if (deviceType <= 8){
                    Long num = (Long)map.get("num");
                    DeviceCountDTO deviceCountDTO = list.get(deviceType - 1);
                    if (deviceCountDTO != null){
                        deviceCountDTO.setNum(num);
                    }
                }
            }
        }
        return list;
    }


    @Override
    public List<DeviceCountDTO> sparePartsMonitoring(BaseReqVO request) {
        List<DeviceCountDTO> list = new ArrayList<>();
        initDeviceCountList(list);
        QueryWrapper<SbSparePartsList> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(request.getSiteId() != null,SbSparePartsList::getSiteId, request.getSiteId())
                .groupBy(SbSparePartsList::getDeviceType);
        queryWrapper.select("device_type,count(*) num");
        List<Map<String, Object>> maps = sbSparePartsListService.listMaps(queryWrapper);
        for (Map<String, Object> map : maps) {
            if (map.get("device_type") != null && map.get("num") != null ){
                Integer deviceType = (Integer)map.get("device_type");
                if (deviceType <= 8){
                    Long num = (Long)map.get("num");
                    DeviceCountDTO deviceCountDTO = list.get(deviceType - 1);
                    if (deviceCountDTO != null){
                        deviceCountDTO.setNum(num);
                    }
                }
            }
        }
        return list;
    }

    @Override
    public List<DeviceCountDTO> toolMonitoring(BaseReqVO request) {
      //  ToolMonitoringDTO toolMonitoringDTO = new ToolMonitoringDTO();
        List<DeviceCountDTO> list = new ArrayList<>();
        initWorkDeviceCountList(list);

        QueryWrapper<SbToolMonitoring> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(request.getSiteId() != null,SbToolMonitoring::getSiteId, request.getSiteId())
                .groupBy(SbToolMonitoring::getDeviceType);
        queryWrapper.select("device_type,count(*) num");
        List<Map<String, Object>> maps = sbToolMonitoringService.listMaps(queryWrapper);
        for (Map<String, Object> map : maps) {
            if (map.get("device_type") != null && map.get("num") != null ){
                Integer deviceType = (Integer)map.get("device_type");
                if (deviceType <= 6){
                    Long num = (Long)map.get("num");
                    DeviceCountDTO deviceCountDTO = list.get(deviceType - 1);
                    if (deviceCountDTO != null){
                        deviceCountDTO.setNum(num);
                    }
                }
            }
        }
      /*  toolMonitoringDTO.setDeviceCountDTOS(list);
        toolMonitoringDTO.setSbToolMonitorings(newSbToolMonitoring);*/
        return list;
    }


    @Override
    public List<DeviceCountDTO> secondaryEquipment(BaseReqVO request) {
        List<DeviceCountDTO> list = new ArrayList<>();
        iniTSecondaryEquipmentCountList(list);

        QueryWrapper<SbSecondaryEquipmentMonitoring> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(request.getSiteId() != null,SbSecondaryEquipmentMonitoring::getSiteId, request.getSiteId())
                .groupBy(SbSecondaryEquipmentMonitoring::getDeviceType);
        queryWrapper.select("device_type,count(*) num");
        List<Map<String, Object>> maps = sbSecondaryEquipmentMonitoringService.listMaps(queryWrapper);
        for (Map<String, Object> map : maps) {
            if (map.get("device_type") != null && map.get("num") != null ){
                Integer deviceType = (Integer)map.get("device_type");
                if (deviceType <= 6){
                    Long num = (Long)map.get("num");
                    DeviceCountDTO deviceCountDTO = list.get(deviceType - 1);
                    if (deviceCountDTO != null){
                        deviceCountDTO.setNum(num);
                    }
                }
            }
        }
        return list;
    }

    @Override
    public List<DeviceCountDTO> performanceManagement(BaseReqVO request) {
        List<DeviceCountDTO> list = new ArrayList<>();
        DeviceCountDTO firstDevice = new DeviceCountDTO();
        int firstNum = jobTicketService.count(new QueryWrapper<JobTicket>().lambda()
                .eq(JobTicket::getSiteId, request.getSiteId())
                .eq(JobTicket::getTicketType, "第一种")
        );

        firstDevice.setEquipmentName("第一种工作票");
        firstDevice.setNum(Long.parseLong(firstNum+""));
        list.add(firstDevice);

        int secondNum = jobTicketService.count(new QueryWrapper<JobTicket>().lambda()
                .eq(JobTicket::getSiteId, request.getSiteId())
                .eq(JobTicket::getTicketType, "第二种")
        );
        DeviceCountDTO secondDevice = new DeviceCountDTO();
        secondDevice.setEquipmentName("第二种工作票");
        secondDevice.setNum(Long.parseLong(secondNum+""));


        int count = jobOperationTicketService.count(new QueryWrapper<JobOperationTicket>().lambda()
                .eq(JobOperationTicket::getSiteId, request.getSiteId()));
        DeviceCountDTO threeDevice = new DeviceCountDTO();
        threeDevice.setEquipmentName("操作票");
        threeDevice.setNum(Long.parseLong(count+""));
        list.add(threeDevice);

        DeviceCountDTO fourDevice = new DeviceCountDTO();
        int jobCount = jobMaintenanceWorkService.count(new QueryWrapper<JobMaintenanceWork>().lambda()
                .eq(JobMaintenanceWork::getSiteId, request.getSiteId()));
        fourDevice.setEquipmentName("维护任务");
        fourDevice.setNum(Long.parseLong(jobCount+""));
        list.add(fourDevice);

        DeviceCountDTO fiveDevice = new DeviceCountDTO();
        int jobPatrolCount = jobPatrolTaskService.count(new QueryWrapper<JobPatrolTask>().lambda()
                .eq(JobPatrolTask::getSiteId, request.getSiteId()));
        fiveDevice.setEquipmentName("巡视任务");
        fiveDevice.setNum(Long.parseLong(jobPatrolCount+""));
        list.add(fiveDevice);

        return list;
    }


    @Override
    public DeviceMonitorDTO getDeviceMonitorCount(BaseReqVO request) {
        DeviceMonitorDTO deviceMonitorDTO = new DeviceMonitorDTO();
        Integer commonNum = sbDefectService.count(new QueryWrapper<SbDefect>().lambda()
                .eq(SbDefect::getSiteId, request.getSiteId())
                .eq(SbDefect::getDefectLevel, EnumDefectStatus.Common.getValue())
                .eq(SbDefect::getStateValue, EnumStateValue.Untreated.getValue())
        );
        deviceMonitorDTO.setGeneralDefectsNum(commonNum);
        Integer severityNum = sbDefectService.count(new QueryWrapper<SbDefect>().lambda()
                .eq(SbDefect::getSiteId, request.getSiteId())
                .eq(SbDefect::getDefectLevel, EnumDefectStatus.Severity.getValue())
                .eq(SbDefect::getStateValue, EnumStateValue.Untreated.getValue())
        );
        deviceMonitorDTO.setSeriousFlawsNum(severityNum);
        Integer criticalNum = sbDefectService.count(new QueryWrapper<SbDefect>().lambda()
                .eq(SbDefect::getSiteId, request.getSiteId())
                .eq(SbDefect::getDefectLevel, EnumDefectStatus.Critical.getValue())
                .eq(SbDefect::getStateValue, EnumStateValue.Untreated.getValue())
        );
        deviceMonitorDTO.setCriticalDefectNum(criticalNum);
        Integer untreatedDangerNum = sbDangerService.count(new QueryWrapper<SbDanger>().lambda()
                .eq(SbDanger::getSiteId, request.getSiteId())
                .eq(SbDanger::getHiddenDangerState, EnumStateValue.Untreated.getValue())
        );
        deviceMonitorDTO.setHiddenNum(untreatedDangerNum);
        Integer UntreatedAlarmNum = sbAlarmService.count(new QueryWrapper<SbAlarm>().lambda()
                .eq(SbAlarm::getSiteId, request.getSiteId())
                .eq(SbAlarm::getAlarmState, EnumStateValue.Untreated.getValue())
        );
        deviceMonitorDTO.setMonitoringAlarmNum(UntreatedAlarmNum);
        int fauleNum = sbFaultService.count(new QueryWrapper<SbFault>().lambda()
                .eq(SbFault::getSiteId, request.getSiteId())
        );
        deviceMonitorDTO.setFailureNum(fauleNum);
        return deviceMonitorDTO;
    }

    @Override
    public AnFireDTO getAnFireCount(BaseReqVO request) {
        AnFireDTO anFireDTO = new AnFireDTO();
        Integer integer = axfDeviceService.getBaseMapper().selectCount(new QueryWrapper<AxfDevice>().lambda()
                .eq(AxfDevice::getSiteId, request.getSiteId())
                .eq(AxfDevice::getAlarmState, EnumAlarmStateType.Processed.getValue())
        );
        anFireDTO.setFireAlarmsNum(integer);
        Integer deviceAbnormalNum = axfDeviceService.getBaseMapper().selectCount(new QueryWrapper<AxfDevice>().lambda()
                .eq(AxfDevice::getSiteId, request.getSiteId())
                .eq(AxfDevice::getDeviceState, 1)

        );
        anFireDTO.setDeviceAbnormalNum(deviceAbnormalNum);
        Integer fireFireNum = axfDeviceService.getBaseMapper().selectCount(new QueryWrapper<AxfDevice>().lambda()
                .eq(AxfDevice::getSiteId, request.getSiteId())
                .eq(AxfDevice::getDeviceType, 3)
        );
        anFireDTO.setFireAlarmsNum(fireFireNum);
        Integer cameraCount = axfDeviceService.getBaseMapper().selectCount(new QueryWrapper<AxfDevice>().lambda()
                .eq(AxfDevice::getSiteId, request.getSiteId())
                .eq(AxfDevice::getDeviceType, EnumAxfDeviceType.Camera.getValue())
        );
        anFireDTO.setImageCameraNum(cameraCount);
        Integer imageDeviceAbnormalNum = axfDeviceService.getBaseMapper().selectCount(new QueryWrapper<AxfDevice>().lambda()
                .eq(AxfDevice::getSiteId, request.getSiteId())
                .eq(AxfDevice::getDeviceType, EnumAxfDeviceType.Camera.getValue())
                .eq(AxfDevice::getDeviceState,"1")
        );
        anFireDTO.setImageDeviceAbnormalNum(imageDeviceAbnormalNum);
        //门禁总数
        Integer displacementNum = axfDeviceService.getBaseMapper().selectCount(new QueryWrapper<AxfDevice>().lambda()
                .eq(AxfDevice::getSiteId, request.getSiteId())
                .eq(AxfDevice::getDeviceType, EnumAxfDeviceType.Displacement.getValue())
        );
        anFireDTO.setAccessNum(displacementNum);
        //门禁装置异常总数
        Integer isplacementNum = axfDeviceService.getBaseMapper().selectCount(new QueryWrapper<AxfDevice>().lambda()
                .eq(AxfDevice::getSiteId, request.getSiteId())
                .eq(AxfDevice::getDeviceType, EnumAxfDeviceType.Displacement.getValue())
                .eq(AxfDevice::getDeviceState,"1")
        );
        anFireDTO.setAccessDeviceAbnormalNum(isplacementNum);
        //门禁告警总数
        Integer processedNum = axfDeviceService.getBaseMapper().selectCount(new QueryWrapper<AxfDevice>().lambda()
                .eq(AxfDevice::getSiteId, request.getSiteId())
                .eq(AxfDevice::getDeviceType, EnumAxfDeviceType.Displacement.getValue())
                .eq(AxfDevice::getAlarmState, EnumAlarmStateType.Processed.getValue())
        );
        anFireDTO.setAccessControlAlarmNum(processedNum);

        Integer zoneElectricFenceNum = axfDeviceService.getBaseMapper().selectCount(new QueryWrapper<AxfDevice>().lambda()
                .eq(AxfDevice::getSiteId, request.getSiteId())
                .eq(AxfDevice::getDeviceType, EnumAxfDeviceType.ElectricFence.getValue())
        );
        anFireDTO.setZoneElectricFenceNum(zoneElectricFenceNum);
        Integer zoneDeviceAbnormalNum = axfDeviceService.getBaseMapper().selectCount(new QueryWrapper<AxfDevice>().lambda()
                .eq(AxfDevice::getSiteId, request.getSiteId())
                .eq(AxfDevice::getDeviceType, EnumAxfDeviceType.ElectricFence.getValue())
                .eq(AxfDevice::getDeviceState,"1")
        );
        anFireDTO.setDeviceAbnormalNum(zoneDeviceAbnormalNum);
        Integer zoneAlarmNum = axfDeviceService.getBaseMapper().selectCount(new QueryWrapper<AxfDevice>().lambda()
                .eq(AxfDevice::getSiteId, request.getSiteId())
                .eq(AxfDevice::getDeviceType, EnumAxfDeviceType.ElectricFence.getValue())
                .eq(AxfDevice::getAlarmState, EnumAlarmStateType.Processed.getValue())
        );
        anFireDTO.setZoneAlarmNum(zoneAlarmNum);
        return anFireDTO;
    }

    @Override
    public InspectionPlanDTO getInspectionPlan(InspectionPlanVO request) {
        InspectionPlanDTO inspectionPlanDTO = new InspectionPlanDTO();
        Integer planTotal = jobRepairService.getBaseMapper().selectCount(new QueryWrapper<JobRepair>().lambda()
                .eq(JobRepair::getSiteId, request.getSiteId())
                .eq(request.getState()!=null,JobRepair::getState,request.getState())
                .gt(request.getStartTime()!= null ,JobRepair::getPlanTime,request.getStartTime())
                .lt(request.getEndTime() != null,JobRepair::getPlanTime,request.getEndTime())
        );
        inspectionPlanDTO.setPlanTotal(planTotal);
        Integer overNum = jobRepairService.getBaseMapper().selectCount(new QueryWrapper<JobRepair>().lambda()
                .eq(JobRepair::getSiteId, request.getSiteId())
                .eq(JobRepair::getOverFlag,1)
                .eq(request.getState()!=null,JobRepair::getState,request.getState())
                .gt(request.getStartTime()!= null ,JobRepair::getPlanTime,request.getStartTime())
                .lt(request.getEndTime() != null,JobRepair::getPlanTime,request.getEndTime())
        );
        inspectionPlanDTO.setIsOverNum(overNum);
        Integer processing = jobRepairService.getBaseMapper().selectCount(new QueryWrapper<JobRepair>().lambda()
                .eq(JobRepair::getSiteId, request.getSiteId())
                .eq(JobRepair::getJobState, EnumJobState.Processing.getValue())
                .eq(request.getState()!=null,JobRepair::getState,request.getState())
                .gt(request.getStartTime()!= null ,JobRepair::getPlanTime,request.getStartTime())
                .lt(request.getEndTime() != null,JobRepair::getPlanTime,request.getEndTime())
        );
        inspectionPlanDTO.setLineNum(processing);
        Integer notStarted = jobRepairService.getBaseMapper().selectCount(new QueryWrapper<JobRepair>().lambda()
                .eq(JobRepair::getSiteId, request.getSiteId())
                .eq(JobRepair::getJobState,EnumJobState.Notstarted.getValue())
                .eq(request.getState()!=null,JobRepair::getState,request.getState())
                .gt(request.getStartTime()!= null ,JobRepair::getPlanTime,request.getStartTime())
                .lt(request.getEndTime() != null,JobRepair::getPlanTime,request.getEndTime())
        );
        inspectionPlanDTO.setNotStartedNum(notStarted);
        Integer completed = jobRepairService.getBaseMapper().selectCount(new QueryWrapper<JobRepair>().lambda()
                .eq(JobRepair::getSiteId, request.getSiteId())
                .eq(JobRepair::getJobState,EnumJobState.Completed.getValue())
                .eq(request.getState()!=null,JobRepair::getState,request.getState())
                .gt(request.getStartTime()!= null ,JobRepair::getPlanTime,request.getStartTime())
                .lt(request.getEndTime() != null,JobRepair::getPlanTime,request.getEndTime())
        );
        inspectionPlanDTO.setCompletedNum(completed);
        return inspectionPlanDTO;
    }


    private void initDeviceCountList(List<DeviceCountDTO> list) {
        DeviceCountDTO d1 = new DeviceCountDTO();
        d1.setEquipmentName("变压器");
        d1.setNum(0L);
        list.add(d1);
        DeviceCountDTO d2 = new DeviceCountDTO();
        d2.setEquipmentName("断路器");
        d2.setNum(0L);
        list.add(d2);
        DeviceCountDTO d3 = new DeviceCountDTO();
        d3.setEquipmentName("电抗器");
        d3.setNum(0L);
        list.add(d3);
        DeviceCountDTO d4 = new DeviceCountDTO();
        d4.setEquipmentName("电流互感器");
        d4.setNum(0L);
        list.add(d4);
        DeviceCountDTO d5 = new DeviceCountDTO();
        d5.setEquipmentName("电压互感器");
        d5.setNum(0L);
        list.add(d5);
        DeviceCountDTO d6 = new DeviceCountDTO();
        d6.setEquipmentName("隔离开关");
        d6.setNum(0L);
        list.add(d6);
        DeviceCountDTO d7 = new DeviceCountDTO();
        d7.setEquipmentName("避雷器");
        d7.setNum(0L);
        list.add(d7);
        DeviceCountDTO d8 = new DeviceCountDTO();
        d8.setEquipmentName("组合电器");
        d8.setNum(0L);
        list.add(d8);
    }



    private void initWorkDeviceCountList(List<DeviceCountDTO> list){
        DeviceCountDTO d1 = new DeviceCountDTO();
        d1.setEquipmentName("绝缘杆");
        d1.setNum(0L);
        list.add(d1);
        DeviceCountDTO d2 = new DeviceCountDTO();
        d2.setEquipmentName("验电器");
        d2.setNum(0L);
        list.add(d2);
        DeviceCountDTO d3 = new DeviceCountDTO();
        d3.setEquipmentName("绝缘手套");
        d3.setNum(0L);
        list.add(d3);
        DeviceCountDTO d4 = new DeviceCountDTO();
        d4.setEquipmentName("绝缘靴");
        d4.setNum(0L);
        list.add(d4);
        DeviceCountDTO d5 = new DeviceCountDTO();
        d5.setEquipmentName("安全带");
        d5.setNum(0L);
        list.add(d5);
        DeviceCountDTO d6 = new DeviceCountDTO();
        d6.setEquipmentName("安全绳");
        d6.setNum(0L);
        list.add(d6);
    }


    private void iniTSecondaryEquipmentCountList(List<DeviceCountDTO> list){
        DeviceCountDTO d1 = new DeviceCountDTO();
        d1.setEquipmentName("变压器保护");
        d1.setNum(0L);
        list.add(d1);
        DeviceCountDTO d2 = new DeviceCountDTO();
        d2.setEquipmentName("母线保护");
        d2.setNum(0L);
        list.add(d2);
        DeviceCountDTO d3 = new DeviceCountDTO();
        d3.setEquipmentName("线路保护");
        d3.setNum(0L);
        list.add(d3);
        DeviceCountDTO d4 = new DeviceCountDTO();
        d4.setEquipmentName("断路器保护");
        d4.setNum(0L);
        list.add(d4);
        DeviceCountDTO d5 = new DeviceCountDTO();
        d5.setEquipmentName("软压板投退");
        d5.setNum(0L);
        list.add(d5);
        DeviceCountDTO d6 = new DeviceCountDTO();
        d5.setEquipmentName("电能表");
        d5.setNum(0L);
        list.add(d6);
    }


}
