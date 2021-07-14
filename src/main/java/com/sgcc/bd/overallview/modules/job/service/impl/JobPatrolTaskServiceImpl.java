package com.sgcc.bd.overallview.modules.job.service.impl;


import com.sgcc.bd.overallview.modules.job.service.JobPatrolTaskService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sgcc.bd.overallview.modules.job.entity.JobPatrolTask;
import com.sgcc.bd.overallview.modules.job.dao.JobPatrolTaskDao;

/**
 * @desc 巡视任务表 serviceImpl
 * @author chenfeixiang
 * @since 2021-07-14
 */
@Service
public class JobPatrolTaskServiceImpl extends ServiceImpl<JobPatrolTaskDao, JobPatrolTask> implements JobPatrolTaskService {

    @Autowired
    JobPatrolTaskDao jobPatrolTaskDao;

}
