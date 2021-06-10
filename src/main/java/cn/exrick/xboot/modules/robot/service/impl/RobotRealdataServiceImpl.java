package cn.exrick.xboot.modules.robot.service.impl;


import cn.exrick.xboot.modules.robot.service.RobotRealdataService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.robot.entity.RobotRealdata;
import cn.exrick.xboot.modules.robot.dao.RobotRealdataDao;

/**
 * @desc 机器人实时数据表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-10
 */
@Service
public class RobotRealdataServiceImpl extends ServiceImpl<RobotRealdataDao, RobotRealdata> implements RobotRealdataService {

    @Autowired
    RobotRealdataDao robotRealdataDao;

}
