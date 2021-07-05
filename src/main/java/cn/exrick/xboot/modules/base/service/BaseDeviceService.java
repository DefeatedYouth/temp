package cn.exrick.xboot.modules.base.service;

import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.Result;
import cn.exrick.xboot.modules.base.dto.AnFireDTO;
import cn.exrick.xboot.modules.base.dto.DeviceCountDTO;
import cn.exrick.xboot.modules.base.dto.DeviceMonitorDTO;
import cn.exrick.xboot.modules.base.dto.InspectionPlanDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.exrick.xboot.modules.base.entity.BaseDevice;

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

    InspectionPlanDTO getInspectionPlan(BaseReqVO request);
}
