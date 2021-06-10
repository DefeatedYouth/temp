package cn.exrick.xboot.modules.robot.service.impl;


import cn.exrick.xboot.modules.robot.service.RobotInspMessageService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.robot.entity.RobotInspMessage;
import cn.exrick.xboot.modules.robot.dao.RobotInspMessageDao;

/**
 * @desc 机器人巡视报文表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-10
 */
@Service
public class RobotInspMessageServiceImpl extends ServiceImpl<RobotInspMessageDao, RobotInspMessage> implements RobotInspMessageService {

    @Autowired
    RobotInspMessageDao robotInspMessageDao;

}
