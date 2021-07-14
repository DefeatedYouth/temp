package com.sgcc.bd.overallview.modules.shebei.service.impl;


import com.sgcc.bd.overallview.modules.shebei.service.SbYousepuService;
import com.sgcc.bd.overallview.modules.shebei.dao.SbYousepuDao;
import com.sgcc.bd.overallview.modules.shebei.entity.SbYousepu;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @desc 设备油色谱表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-21
 */
@Service
public class SbYousepuServiceImpl extends ServiceImpl<SbYousepuDao, SbYousepu> implements SbYousepuService {

    @Autowired
    SbYousepuDao sbYousepuDao;

}
