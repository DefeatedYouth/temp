package cn.exrick.xboot.modules.shebei.service.impl;


import cn.exrick.xboot.modules.shebei.service.SbSecondaryEquipmentMonitoringService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.shebei.entity.SbSecondaryEquipmentMonitoring;
import cn.exrick.xboot.modules.shebei.dao.SbSecondaryEquipmentMonitoringDao;

/**
 * @desc 二次设备监视表 serviceImpl
 * @author chenfeixiang
 * @since 2021-07-07
 */
@Service
public class SbSecondaryEquipmentMonitoringServiceImpl extends ServiceImpl<SbSecondaryEquipmentMonitoringDao, SbSecondaryEquipmentMonitoring> implements SbSecondaryEquipmentMonitoringService {

    @Autowired
    SbSecondaryEquipmentMonitoringDao sbSecondaryEquipmentMonitoringDao;

}
