package com.sgcc.bd.overallview.modules.job.service.impl;


import com.sgcc.bd.overallview.modules.job.dao.JobMaintenanceWorkDao;
import com.sgcc.bd.overallview.modules.job.entity.JobMaintenanceWork;
import com.sgcc.bd.overallview.modules.job.service.JobMaintenanceWorkService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sgcc.bd.overallview.modules.job.dao.JobMaintenanceTasksDao;

/**
 * @desc  serviceImpl
 * @author chenfeixiang
 * @since 2021-07-13
 */
@Service
public class JobMaintenanceWorkServiceImpl extends ServiceImpl<JobMaintenanceWorkDao, JobMaintenanceWork> implements JobMaintenanceWorkService {

/*    @Autowired
    JobMaintenanceTasksDao jobMaintenanceTasksDao;*/

}
