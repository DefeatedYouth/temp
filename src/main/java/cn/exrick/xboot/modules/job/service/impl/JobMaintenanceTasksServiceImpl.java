package cn.exrick.xboot.modules.job.service.impl;


import cn.exrick.xboot.modules.job.service.JobMaintenanceTasksService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.job.entity.JobMaintenanceTasks;
import cn.exrick.xboot.modules.job.dao.JobMaintenanceTasksDao;

/**
 * @desc  serviceImpl
 * @author chenfeixiang
 * @since 2021-07-13
 */
@Service
public class JobMaintenanceTasksServiceImpl extends ServiceImpl<JobMaintenanceTasksDao, JobMaintenanceTasks> implements JobMaintenanceTasksService {

    @Autowired
    JobMaintenanceTasksDao jobMaintenanceTasksDao;

}
