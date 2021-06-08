package cn.exrick.xboot.modules.job.service.impl;


import cn.exrick.xboot.modules.job.service.JobRepairService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.job.entity.JobRepair;
import cn.exrick.xboot.modules.job.dao.JobRepairDao;

/**
 * @desc 检修作业表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class JobRepairServiceImpl extends ServiceImpl<JobRepairDao, JobRepair> implements JobRepairService {

    @Autowired
    JobRepairDao jobRepairDao;

}
