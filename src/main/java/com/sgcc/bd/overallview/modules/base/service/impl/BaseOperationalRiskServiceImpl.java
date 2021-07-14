package com.sgcc.bd.overallview.modules.base.service.impl;


import com.sgcc.bd.overallview.modules.base.service.BaseOperationalRiskService;
import com.sgcc.bd.overallview.modules.base.dao.BaseOperationalRiskDao;
import com.sgcc.bd.overallview.modules.base.entity.BaseOperationalRisk;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @desc 操作风险表 serviceImpl
 * @author chenfeixiang
 * @since 2021-07-08
 */
@Service
public class BaseOperationalRiskServiceImpl extends ServiceImpl<BaseOperationalRiskDao, BaseOperationalRisk> implements BaseOperationalRiskService {

    @Autowired
    BaseOperationalRiskDao baseOperationalRiskDao;

}
