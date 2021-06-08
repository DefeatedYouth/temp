package cn.exrick.xboot.modules.job.service.impl;


import cn.exrick.xboot.modules.job.service.JobTicketService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.job.entity.JobTicket;
import cn.exrick.xboot.modules.job.dao.JobTicketDao;

/**
 * @desc 工作票表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class JobTicketServiceImpl extends ServiceImpl<JobTicketDao, JobTicket> implements JobTicketService {

    @Autowired
    JobTicketDao jobTicketDao;

}
