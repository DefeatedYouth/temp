package com.sgcc.bd.overallview.modules.robot.service.impl;


import com.sgcc.bd.overallview.modules.robot.service.RobotAlarmService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sgcc.bd.overallview.modules.robot.entity.RobotAlarm;
import com.sgcc.bd.overallview.modules.robot.dao.RobotAlarmDao;

/**
 * @desc 机器人本体告警表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-10
 */
@Service
public class RobotAlarmServiceImpl extends ServiceImpl<RobotAlarmDao, RobotAlarm> implements RobotAlarmService {

    @Autowired
    RobotAlarmDao robotAlarmDao;

}
