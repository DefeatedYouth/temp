package cn.exrick.xboot.modules.job.service.impl;


import cn.exrick.xboot.modules.job.service.JobOperationTicketService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.job.entity.JobOperationTicket;
import cn.exrick.xboot.modules.job.dao.JobOperationTicketDao;

/**
 * @desc 操作票表 serviceImpl
 * @author chenfeixiang
 * @since 2021-07-08
 */
@Service
public class JobOperationTicketServiceImpl extends ServiceImpl<JobOperationTicketDao, JobOperationTicket> implements JobOperationTicketService {

    @Autowired
    JobOperationTicketDao jobOperationTicketDao;

}
