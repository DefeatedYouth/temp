package com.sgcc.bd.overallview.modules.robot.service.impl;


import com.sgcc.bd.overallview.modules.robot.service.RobotBookService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sgcc.bd.overallview.modules.robot.entity.RobotBook;
import com.sgcc.bd.overallview.modules.robot.dao.RobotBookDao;

/**
 * @desc 机器人台账表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-10
 */
@Service
public class RobotBookServiceImpl extends ServiceImpl<RobotBookDao, RobotBook> implements RobotBookService {

    @Autowired
    RobotBookDao robotBookDao;

}
