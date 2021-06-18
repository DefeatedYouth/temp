package cn.exrick.xboot.modules.base.service.impl;


import cn.exrick.xboot.modules.base.service.BaseSystemMonitoringService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.base.entity.BaseSystemMonitoring;
import cn.exrick.xboot.modules.base.dao.BaseSystemMonitoringDao;

/**
 * @desc 交直流系统监视表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-18
 */
@Service
public class BaseSystemMonitoringServiceImpl extends ServiceImpl<BaseSystemMonitoringDao, BaseSystemMonitoring> implements BaseSystemMonitoringService {

    @Autowired
    BaseSystemMonitoringDao baseSystemMonitoringDao;

}
