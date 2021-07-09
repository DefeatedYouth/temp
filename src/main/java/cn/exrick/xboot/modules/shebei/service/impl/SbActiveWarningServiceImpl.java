package cn.exrick.xboot.modules.shebei.service.impl;


import cn.exrick.xboot.modules.shebei.service.SbActiveWarningService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.shebei.entity.SbActiveWarning;
import cn.exrick.xboot.modules.shebei.dao.SbActiveWarningDao;

/**
 * @desc 设备主动预警表 serviceImpl
 * @author chenfeixiang
 * @since 2021-07-09
 */
@Service
public class SbActiveWarningServiceImpl extends ServiceImpl<SbActiveWarningDao, SbActiveWarning> implements SbActiveWarningService {

    @Autowired
    SbActiveWarningDao sbActiveWarningDao;

}
