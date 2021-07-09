package cn.exrick.xboot.modules.shebei.service.impl;


import cn.exrick.xboot.modules.shebei.service.SbPlanAidedDecisionService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.shebei.entity.SbPlanAidedDecision;
import cn.exrick.xboot.modules.shebei.dao.SbPlanAidedDecisionDao;

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
