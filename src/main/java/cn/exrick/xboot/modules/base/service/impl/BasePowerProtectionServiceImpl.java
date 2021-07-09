package cn.exrick.xboot.modules.base.service.impl;


import cn.exrick.xboot.modules.base.service.BasePowerProtectionService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.base.entity.BasePowerProtection;
import cn.exrick.xboot.modules.base.dao.BasePowerProtectionDao;

/**
 * @desc 保电表 serviceImpl
 * @author chenfeixiang
 * @since 2021-07-07
 */
@Service
public class BasePowerProtectionServiceImpl extends ServiceImpl<BasePowerProtectionDao, BasePowerProtection> implements BasePowerProtectionService {

    @Autowired
    BasePowerProtectionDao basePowerProtectionDao;

}
