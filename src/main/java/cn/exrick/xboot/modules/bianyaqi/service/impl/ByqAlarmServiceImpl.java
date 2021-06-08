package cn.exrick.xboot.modules.bianyaqi.service.impl;


import cn.exrick.xboot.modules.bianyaqi.service.ByqAlarmService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.bianyaqi.entity.ByqAlarm;
import cn.exrick.xboot.modules.bianyaqi.dao.ByqAlarmDao;

/**
 * @desc 变压器告警信息 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class ByqAlarmServiceImpl extends ServiceImpl<ByqAlarmDao, ByqAlarm> implements ByqAlarmService {

    @Autowired
    ByqAlarmDao byqAlarmDao;

}
