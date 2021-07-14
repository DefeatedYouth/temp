package com.sgcc.bd.overallview.modules.base.service.impl;


import com.sgcc.bd.overallview.modules.base.service.BaseCameraRecordsService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sgcc.bd.overallview.modules.base.entity.BaseCameraRecords;
import com.sgcc.bd.overallview.modules.base.dao.BaseCameraRecordsDao;

/**
 * @desc  摄像机录像识别记录表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class BaseCameraRecordsServiceImpl extends ServiceImpl<BaseCameraRecordsDao, BaseCameraRecords> implements BaseCameraRecordsService {

    @Autowired
    BaseCameraRecordsDao baseCameraRecordsDao;

}
