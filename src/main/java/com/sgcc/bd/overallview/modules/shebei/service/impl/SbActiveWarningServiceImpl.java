package com.sgcc.bd.overallview.modules.shebei.service.impl;


import com.sgcc.bd.overallview.modules.shebei.service.SbActiveWarningService;
import com.sgcc.bd.overallview.modules.shebei.dao.SbActiveWarningDao;
import com.sgcc.bd.overallview.modules.shebei.entity.SbActiveWarning;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @desc 设备主动预警表 serviceImpl
 * @author chenfeixiang
 * @since 2021-07-09
 */
@Service
public class SbActiveWarningServiceImpl extends ServiceImpl<SbActiveWarningDao, SbActiveWarning> implements SbActiveWarningService {

    @Autowired
    SbActiveWarningDao sbActiveWarningDao;

}
