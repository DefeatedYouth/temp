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
import cn.exrick.xboot.modules.shebei.entity.SbAlarm;
import cn.exrick.xboot.modules.shebei.entity.SbDanger;
import cn.exrick.xboot.modules.shebei.entity.SbDefect;
import cn.exrick.xboot.modules.shebei.entity.SbFault;
import cn.exrick.xboot.modules.shebei.service.SbAlarmService;
import cn.exrick.xboot.modules.shebei.service.SbDangerService;
import cn.exrick.xboot.modules.shebei.service.SbDefectService;
import cn.exrick.xboot.modules.shebei.service.SbFaultService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.base.entity.BaseDevice;
import cn.exrick.xboot.modules.base.dao.BaseDeviceDao;

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
    public DeviceCountDTO getDeviceCount(BaseReqVO request) {
        DeviceCountDTO deviceCountDTO = new DeviceCountDTO();
        int transformerNum = this.count(new QueryWrapper<BaseDevice>().lambda()
                .eq(BaseDevice::getSiteId, request.getSiteId())
                .eq(BaseDevice::getDeviceType,1)
        );
        deviceCountDTO.setTransformerNum(transformerNum);
        int reactorNum = this.count(new QueryWrapper<BaseDevice>().lambda()
                .eq(BaseDevice::getSiteId, request.getSiteId())
                .eq(BaseDevice::getDeviceType,2)
        );
        deviceCountDTO.setReactorNum(reactorNum);
        int breakerNum = this.count(new QueryWrapper<BaseDevice>().lambda()
                .eq(BaseDevice::getSiteId, request.getSiteId())
                .eq(BaseDevice::getDeviceType,3)
        );
        deviceCountDTO.setBreakerNum(breakerNum);
        int currentTransformerNum = this.count(new QueryWrapper<BaseDevice>().lambda()
                .eq(BaseDevice::getSiteId, request.getSiteId())
                .eq(BaseDevice::getDeviceType,4)
        );
        deviceCountDTO.setCurrentTransformerNum(currentTransformerNum);
        int voltageTransformerNum = this.count(new QueryWrapper<BaseDevice>().lambda()
                .eq(BaseDevice::getSiteId, request.getSiteId())
                .eq(BaseDevice::getDeviceType,5)
        );
        deviceCountDTO.setVoltageTransformerNum(voltageTransformerNum);
        int isolatingSwitchNum = this.count(new QueryWrapper<BaseDevice>().lambda()
                .eq(BaseDevice::getSiteId, request.getSiteId())
                .eq(BaseDevice::getDeviceType,6)
        );
        deviceCountDTO.setIsolatingSwitchNum(isolatingSwitchNum);
        int lightningArresterNum = this.count(new QueryWrapper<BaseDevice>().lambda()
                .eq(BaseDevice::getSiteId, request.getSiteId())
                .eq(BaseDevice::getDeviceType,7)
        );
        deviceCountDTO.setLightningArresterNum(lightningArresterNum);
        int combinationAppliancesNum = this.count(new QueryWrapper<BaseDevice>().lambda()
                .eq(BaseDevice::getSiteId, request.getSiteId())
                .eq(BaseDevice::getDeviceType,8)
        );
        deviceCountDTO.setCombinationAppliancesNum(combinationAppliancesNum);
        return deviceCountDTO;
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
}
