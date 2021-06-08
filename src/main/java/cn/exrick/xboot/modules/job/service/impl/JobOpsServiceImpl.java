package cn.exrick.xboot.modules.job.service.impl;


import cn.exrick.xboot.modules.job.service.JobOpsService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.job.entity.JobOps;
import cn.exrick.xboot.modules.job.dao.JobOpsDao;

/**
 * @desc 运维作业表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class JobOpsServiceImpl extends ServiceImpl<JobOpsDao, JobOps> implements JobOpsService {

    @Autowired
    JobOpsDao jobOpsDao;

}
