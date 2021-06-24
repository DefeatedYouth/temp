package cn.exrick.xboot.modules.anxiaofang.service;

import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.Result;
import cn.exrick.xboot.modules.anxiaofang.dto.AccessControlInformationDTO;
import cn.exrick.xboot.modules.anxiaofang.dto.ElectronicFenceDTO;
import cn.exrick.xboot.modules.anxiaofang.dto.FirefightovweviewDTO;
import cn.exrick.xboot.modules.anxiaofang.dto.InfraredRadiationCountDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.exrick.xboot.modules.anxiaofang.entity.AxfDevice;


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
