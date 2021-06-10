package cn.exrick.xboot.modules.robot.service.impl;


import cn.exrick.xboot.modules.robot.service.RobotInspRecordsService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.robot.entity.RobotInspRecords;
import cn.exrick.xboot.modules.robot.dao.RobotInspRecordsDao;

/**
 * @desc 机器人巡视记录表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-10
 */
@Service
public class RobotInspRecordsServiceImpl extends ServiceImpl<RobotInspRecordsDao, RobotInspRecords> implements RobotInspRecordsService {

    @Autowired
    RobotInspRecordsDao robotInspRecordsDao;

}
