package com.sgcc.bd.overallview.modules.base.service.impl;


import com.sgcc.bd.overallview.modules.base.service.BaseCameraService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sgcc.bd.overallview.modules.base.entity.BaseCamera;
import com.sgcc.bd.overallview.modules.base.dao.BaseCameraDao;

/**
 * @desc  摄像机表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class BaseCameraServiceImpl extends ServiceImpl<BaseCameraDao, BaseCamera> implements BaseCameraService {

    @Autowired
    BaseCameraDao baseCameraDao;

}
