package com.sgcc.bd.overallview.modules.anxiaofang.service;

import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.modules.anxiaofang.dto.AccessControlInformationDTO;
import com.sgcc.bd.overallview.modules.anxiaofang.dto.ElectronicFenceDTO;
import com.sgcc.bd.overallview.modules.anxiaofang.dto.FirefightovweviewDTO;
import com.sgcc.bd.overallview.modules.anxiaofang.dto.InfraredRadiationCountDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sgcc.bd.overallview.modules.anxiaofang.entity.AxfDevice;


/**
 * @desc 安消防设备监视表 service
 * @author chenfeixiang
 * @since 2021-06-08
 */
public interface AxfDeviceService  extends IService<AxfDevice>{

    FirefightovweviewDTO fireFightingOvweview(BaseReqVO request);

    InfraredRadiationCountDTO infraredRadiationCount(BaseReqVO request);

    InfraredRadiationCountDTO infraredDoubleDetector(BaseReqVO request);

    InfraredRadiationCountDTO   cameraInfoCount(BaseReqVO request);

    ElectronicFenceDTO electronicFenceNum(BaseReqVO request);

    AccessControlInformationDTO   accessControlInformation(BaseReqVO request);

}
