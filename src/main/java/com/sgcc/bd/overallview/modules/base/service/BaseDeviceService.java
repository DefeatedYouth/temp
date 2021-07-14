package com.sgcc.bd.overallview.modules.base.service;

import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.common.vo.InspectionPlanVO;
import com.sgcc.bd.overallview.modules.base.dto.AnFireDTO;
import com.sgcc.bd.overallview.modules.base.dto.DeviceCountDTO;
import com.sgcc.bd.overallview.modules.base.dto.DeviceMonitorDTO;
import com.sgcc.bd.overallview.modules.base.dto.InspectionPlanDTO;
import com.sgcc.bd.overallview.modules.overview.dto.ToolMonitoringDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sgcc.bd.overallview.modules.base.entity.BaseDevice;

import java.util.List;


/**
 * @desc 主设备表 service
 * @author chenfeixiang
 * @since 2021-06-08
 */
public interface BaseDeviceService  extends IService<BaseDevice>{

    List<DeviceCountDTO> getDeviceCount(BaseReqVO request);

    DeviceMonitorDTO getDeviceMonitorCount(BaseReqVO request);

    AnFireDTO getAnFireCount(BaseReqVO request);

    InspectionPlanDTO getInspectionPlan(InspectionPlanVO request);

    List<DeviceCountDTO> sparePartsMonitoring(BaseReqVO request);

    ToolMonitoringDTO toolMonitoring(BaseReqVO request);

    List<DeviceCountDTO> secondaryEquipment(BaseReqVO request);

    List<DeviceCountDTO> performanceManagement(BaseReqVO request);
}
