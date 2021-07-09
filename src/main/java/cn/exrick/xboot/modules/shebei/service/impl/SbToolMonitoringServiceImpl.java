package cn.exrick.xboot.modules.shebei.service.impl;


import cn.exrick.xboot.modules.shebei.service.SbToolMonitoringService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.shebei.entity.SbToolMonitoring;
import cn.exrick.xboot.modules.shebei.dao.SbToolMonitoringDao;

/**
 * @desc 工器具监视表 serviceImpl
 * @author chenfeixiang
 * @since 2021-07-07
 */
@Service
public class SbToolMonitoringServiceImpl extends ServiceImpl<SbToolMonitoringDao, SbToolMonitoring> implements SbToolMonitoringService {

    @Autowired
    SbToolMonitoringDao sbToolMonitoringDao;

}
