package cn.exrick.xboot.modules.duanluqi.service.impl;


import cn.exrick.xboot.modules.duanluqi.service.DlqAlarmService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.duanluqi.entity.DlqAlarm;
import cn.exrick.xboot.modules.duanluqi.dao.DlqAlarmDao;

/**
 * @desc 断路器告警数据表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class DlqAlarmServiceImpl extends ServiceImpl<DlqAlarmDao, DlqAlarm> implements DlqAlarmService {

    @Autowired
    DlqAlarmDao dlqAlarmDao;

}
