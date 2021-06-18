package cn.exrick.xboot.modules.anxiaofang.service;

import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.modules.anxiaofang.dto.FirefightovweviewDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.exrick.xboot.modules.anxiaofang.entity.AxfDevice;


/**
 * @desc 安消防设备监视表 service
 * @author chenfeixiang
 * @since 2021-06-08
 */
public interface AxfDeviceService  extends IService<AxfDevice>{

    FirefightovweviewDTO fireFightingOvweview(BaseReqVO request);
}
