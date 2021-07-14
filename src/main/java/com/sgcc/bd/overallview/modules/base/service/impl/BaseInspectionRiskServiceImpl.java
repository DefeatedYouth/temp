package com.sgcc.bd.overallview.modules.base.service.impl;


import com.sgcc.bd.overallview.modules.base.service.BaseInspectionRiskService;
import com.sgcc.bd.overallview.modules.base.dao.BaseInspectionRiskDao;
import com.sgcc.bd.overallview.modules.base.entity.BaseInspectionRisk;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @desc 巡视风险表 serviceImpl
 * @author chenfeixiang
 * @since 2021-07-07
 */
@Service
public class BaseInspectionRiskServiceImpl extends ServiceImpl<BaseInspectionRiskDao, BaseInspectionRisk> implements BaseInspectionRiskService {

    @Autowired
    BaseInspectionRiskDao baseInspectionRiskDao;

}
