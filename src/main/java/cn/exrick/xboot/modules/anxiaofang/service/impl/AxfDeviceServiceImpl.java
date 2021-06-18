package cn.exrick.xboot.modules.anxiaofang.service.impl;


import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.modules.anxiaofang.dto.FirefightovweviewDTO;
import cn.exrick.xboot.modules.anxiaofang.service.AxfDeviceService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.anxiaofang.entity.AxfDevice;
import cn.exrick.xboot.modules.anxiaofang.dao.AxfDeviceDao;

/**
 * @desc 安消防设备监视表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class AxfDeviceServiceImpl extends ServiceImpl<AxfDeviceDao, AxfDevice> implements AxfDeviceService {

    @Autowired
    AxfDeviceDao axfDeviceDao;

    @Override
    public FirefightovweviewDTO fireFightingOvweview(BaseReqVO request) {
    try {
        FirefightovweviewDTO firefightovweviewDTO = new FirefightovweviewDTO();
        int total = this.count(new QueryWrapper<AxfDevice>().lambda()
                .eq(AxfDevice::getSiteId, request.getSiteId()));
        firefightovweviewDTO.setTotalFireFightingNum(total);
        return firefightovweviewDTO;
    }catch (Exception e){
        e.printStackTrace();
        return null;
    }
    }
}
