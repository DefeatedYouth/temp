package cn.exrick.xboot.modules.robot.service.impl;


import cn.exrick.xboot.modules.robot.service.RobotResumeService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.robot.entity.RobotResume;
import cn.exrick.xboot.modules.robot.dao.RobotResumeDao;

/**
 * @desc 机器人履历 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class RobotResumeServiceImpl extends ServiceImpl<RobotResumeDao, RobotResume> implements RobotResumeService {

    @Autowired
    RobotResumeDao robotResumeDao;

}
