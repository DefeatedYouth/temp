package cn.exrick.xboot.modules.shebei.service.impl;


import cn.exrick.xboot.modules.shebei.service.SbAlarmService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.shebei.entity.SbAlarm;
import cn.exrick.xboot.modules.shebei.dao.SbAlarmDao;

/**
 * @desc 断路器告警数据表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-15
 */
@Service
public class SbAlarmServiceImpl extends ServiceImpl<SbAlarmDao, SbAlarm> implements SbAlarmService {

    @Autowired
    SbAlarmDao sbAlarmDao;

}
