package cn.exrick.xboot.modules.base.service.impl;


import cn.exrick.xboot.modules.base.service.BaseInspectionRiskService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.base.entity.BaseInspectionRisk;
import cn.exrick.xboot.modules.base.dao.BaseInspectionRiskDao;

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
