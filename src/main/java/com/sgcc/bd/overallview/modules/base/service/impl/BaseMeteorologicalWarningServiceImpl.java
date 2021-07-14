package com.sgcc.bd.overallview.modules.base.service.impl;


import com.sgcc.bd.overallview.modules.base.service.BaseMeteorologicalWarningService;
import com.sgcc.bd.overallview.modules.base.dao.BaseMeteorologicalWarningDao;
import com.sgcc.bd.overallview.modules.base.entity.BaseMeteorologicalWarning;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @desc 气象预警 serviceImpl
 * @author chenfeixiang
 * @since 2021-07-07
 */
@Service
public class BaseMeteorologicalWarningServiceImpl extends ServiceImpl<BaseMeteorologicalWarningDao, BaseMeteorologicalWarning> implements BaseMeteorologicalWarningService {

    @Autowired
    BaseMeteorologicalWarningDao baseMeteorologicalWarningDao;

}
