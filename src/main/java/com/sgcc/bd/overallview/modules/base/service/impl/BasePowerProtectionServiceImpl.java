package com.sgcc.bd.overallview.modules.base.service.impl;


import com.sgcc.bd.overallview.modules.base.service.BasePowerProtectionService;
import com.sgcc.bd.overallview.modules.base.dao.BasePowerProtectionDao;
import com.sgcc.bd.overallview.modules.base.entity.BasePowerProtection;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @desc 保电表 serviceImpl
 * @author chenfeixiang
 * @since 2021-07-07
 */
@Service
public class BasePowerProtectionServiceImpl extends ServiceImpl<BasePowerProtectionDao, BasePowerProtection> implements BasePowerProtectionService {

    @Autowired
    BasePowerProtectionDao basePowerProtectionDao;

}
