package cn.exrick.xboot.modules.base.service.impl;


import cn.exrick.xboot.common.enums.*;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.modules.anxiaofang.entity.AxfDevice;
import cn.exrick.xboot.modules.anxiaofang.service.AxfDeviceService;
import cn.exrick.xboot.modules.base.dto.AnFireDTO;
import cn.exrick.xboot.modules.base.dto.DeviceCountDTO;
import cn.exrick.xboot.modules.base.dto.DeviceMonitorDTO;
import cn.exrick.xboot.modules.base.dto.InspectionPlanDTO;
import cn.exrick.xboot.modules.base.service.BaseDeviceService;
import cn.exrick.xboot.modules.job.entity.JobRepair;
import cn.exrick.xboot.modules.job.service.JobRepairService;
import cn.exrick.xboot.modules.shebei.entity.*;
import cn.exrick.xboot.modules.shebei.service.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.base.entity.BaseDevice;
import cn.exrick.xboot.modules.base.dao.BaseDeviceDao;

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
    public InspectionPlanDTO getInspectionPlan(BaseReqVO request) {
        InspectionPlanDTO inspectionPlanDTO = new InspectionPlanDTO();
        Integer planTotal = jobRepairService.getBaseMapper().selectCount(new QueryWrapper<JobRepair>().lambda()
                .eq(JobRepair::getSiteId, request.getSiteId())
        );
        inspectionPlanDTO.setPlanTotal(planTotal);
        Integer processing = jobRepairService.getBaseMapper().selectCount(new QueryWrapper<JobRepair>().lambda()
                .eq(JobRepair::getSiteId, request.getSiteId())
                .eq(JobRepair::getJobState,EnumJobState.Processing.getValue())
        );
        inspectionPlanDTO.setLineNum(processing);
        Integer notStarted = jobRepairService.getBaseMapper().selectCount(new QueryWrapper<JobRepair>().lambda()
                .eq(JobRepair::getSiteId, request.getSiteId())
                .eq(JobRepair::getJobState,EnumJobState.Notstarted.getValue())
        );
        inspectionPlanDTO.setNotStartedNum(notStarted);
        Integer completed = jobRepairService.getBaseMapper().selectCount(new QueryWrapper<JobRepair>().lambda()
                .eq(JobRepair::getSiteId, request.getSiteId())
                .eq(JobRepair::getJobState,EnumJobState.Completed.getValue())
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
}
