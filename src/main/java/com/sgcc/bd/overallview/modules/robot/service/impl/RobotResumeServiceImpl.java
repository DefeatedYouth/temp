package com.sgcc.bd.overallview.modules.robot.service.impl;


import com.sgcc.bd.overallview.modules.robot.service.RobotResumeService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sgcc.bd.overallview.modules.robot.entity.RobotResume;
import com.sgcc.bd.overallview.modules.robot.dao.RobotResumeDao;

/**
 * @desc 机器人履历 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-10
 */
@Service
public class RobotResumeServiceImpl extends ServiceImpl<RobotResumeDao, RobotResume> implements RobotResumeService {

    @Autowired
    RobotResumeDao robotResumeDao;

}
