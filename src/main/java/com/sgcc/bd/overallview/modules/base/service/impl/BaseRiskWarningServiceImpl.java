package com.sgcc.bd.overallview.modules.base.service.impl;


import com.sgcc.bd.overallview.modules.base.service.BaseRiskWarningService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sgcc.bd.overallview.modules.base.entity.BaseRiskWarning;
import com.sgcc.bd.overallview.modules.base.dao.BaseRiskWarningDao;

/**
 * @desc 交直流系统监视表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-18
 */
@Service
public class BaseRiskWarningServiceImpl extends ServiceImpl<BaseRiskWarningDao, BaseRiskWarning> implements BaseRiskWarningService {

    @Autowired
    BaseRiskWarningDao baseRiskWarningDao;

}
