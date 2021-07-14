package com.sgcc.bd.overallview.modules.shebei.service.impl;


import com.sgcc.bd.overallview.modules.shebei.service.SbSfsixService;
import com.sgcc.bd.overallview.modules.shebei.dao.SbSfsixDao;
import com.sgcc.bd.overallview.modules.shebei.entity.SbSfsix;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @desc 断路器sf6监测数据表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-15
 */
@Service
public class SbSfsixServiceImpl extends ServiceImpl<SbSfsixDao, SbSfsix> implements SbSfsixService {

    @Autowired
    SbSfsixDao sbSfsixDao;

}
