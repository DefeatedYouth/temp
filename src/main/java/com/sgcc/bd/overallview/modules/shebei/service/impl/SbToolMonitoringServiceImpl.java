package com.sgcc.bd.overallview.modules.shebei.service.impl;


import com.sgcc.bd.overallview.modules.shebei.service.SbToolMonitoringService;
import com.sgcc.bd.overallview.modules.shebei.dao.SbToolMonitoringDao;
import com.sgcc.bd.overallview.modules.shebei.entity.SbToolMonitoring;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

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
