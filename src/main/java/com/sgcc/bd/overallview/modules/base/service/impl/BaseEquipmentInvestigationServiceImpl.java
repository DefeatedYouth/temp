package com.sgcc.bd.overallview.modules.base.service.impl;


import com.sgcc.bd.overallview.modules.base.service.BaseEquipmentInvestigationService;
import com.sgcc.bd.overallview.modules.base.dao.BaseEquipmentInvestigationDao;
import com.sgcc.bd.overallview.modules.base.entity.BaseEquipmentInvestigation;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @desc 设备排查表 serviceImpl
 * @author chenfeixiang
 * @since 2021-07-07
 */
@Service
public class BaseEquipmentInvestigationServiceImpl extends ServiceImpl<BaseEquipmentInvestigationDao, BaseEquipmentInvestigation> implements BaseEquipmentInvestigationService {

    @Autowired
    BaseEquipmentInvestigationDao baseEquipmentInvestigationDao;

}
