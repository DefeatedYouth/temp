package cn.exrick.xboot.modules.base.service.impl;


import cn.exrick.xboot.modules.base.service.BaseMeteorologicalWarningService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.base.entity.BaseMeteorologicalWarning;
import cn.exrick.xboot.modules.base.dao.BaseMeteorologicalWarningDao;

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
