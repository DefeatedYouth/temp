package com.sgcc.bd.overallview.modules.job.service.impl;


import com.sgcc.bd.overallview.modules.job.service.JobOperationTicketService;
import com.sgcc.bd.overallview.modules.job.dao.JobOperationTicketDao;
import com.sgcc.bd.overallview.modules.job.entity.JobOperationTicket;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

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
