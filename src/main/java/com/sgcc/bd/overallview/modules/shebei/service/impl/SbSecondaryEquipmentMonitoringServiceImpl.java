package com.sgcc.bd.overallview.modules.shebei.service.impl;


import com.sgcc.bd.overallview.modules.shebei.service.SbSecondaryEquipmentMonitoringService;
import com.sgcc.bd.overallview.modules.shebei.dao.SbSecondaryEquipmentMonitoringDao;
import com.sgcc.bd.overallview.modules.shebei.entity.SbSecondaryEquipmentMonitoring;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

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
