package com.sgcc.bd.overallview.modules.shebei.service.impl;


import com.sgcc.bd.overallview.modules.shebei.service.SbLiveDetectionService;
import com.sgcc.bd.overallview.modules.shebei.dao.SbLiveDetectionDao;
import com.sgcc.bd.overallview.modules.shebei.entity.SbLiveDetection;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @desc 设备带电测试记录表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-21
 */
@Service
public class SbLiveDetectionServiceImpl extends ServiceImpl<SbLiveDetectionDao, SbLiveDetection> implements SbLiveDetectionService {

    @Autowired
    SbLiveDetectionDao sbLiveDetectionDao;

}
