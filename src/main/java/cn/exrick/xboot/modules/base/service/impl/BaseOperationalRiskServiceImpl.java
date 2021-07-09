package cn.exrick.xboot.modules.base.service.impl;


import cn.exrick.xboot.modules.base.service.BaseOperationalRiskService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.base.entity.BaseOperationalRisk;
import cn.exrick.xboot.modules.base.dao.BaseOperationalRiskDao;

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
