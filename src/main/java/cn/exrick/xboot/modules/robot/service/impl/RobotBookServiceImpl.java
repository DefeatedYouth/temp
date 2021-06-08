package cn.exrick.xboot.modules.robot.service.impl;


import cn.exrick.xboot.modules.robot.service.RobotBookService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.robot.entity.RobotBook;
import cn.exrick.xboot.modules.robot.dao.RobotBookDao;

/**
 * @desc 机器人台账表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class RobotBookServiceImpl extends ServiceImpl<RobotBookDao, RobotBook> implements RobotBookService {

    @Autowired
    RobotBookDao robotBookDao;

}
