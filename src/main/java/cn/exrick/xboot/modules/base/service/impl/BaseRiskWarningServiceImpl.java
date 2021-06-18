package cn.exrick.xboot.modules.base.service.impl;


import cn.exrick.xboot.modules.base.service.BaseRiskWarningService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.base.entity.BaseRiskWarning;
import cn.exrick.xboot.modules.base.dao.BaseRiskWarningDao;

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
