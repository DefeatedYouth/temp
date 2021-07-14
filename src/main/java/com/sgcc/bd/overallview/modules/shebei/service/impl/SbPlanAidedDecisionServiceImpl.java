package com.sgcc.bd.overallview.modules.shebei.service.impl;


import com.sgcc.bd.overallview.modules.shebei.service.SbPlanAidedDecisionService;
import com.sgcc.bd.overallview.modules.shebei.dao.SbPlanAidedDecisionDao;
import com.sgcc.bd.overallview.modules.shebei.entity.SbPlanAidedDecision;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @desc 计划辅助决策表 serviceImpl
 * @author chenfeixiang
 * @since 2021-07-07
 */
@Service
public class SbPlanAidedDecisionServiceImpl extends ServiceImpl<SbPlanAidedDecisionDao, SbPlanAidedDecision> implements SbPlanAidedDecisionService {

    @Autowired
    SbPlanAidedDecisionDao sbPlanAidedDecisionDao;

}
