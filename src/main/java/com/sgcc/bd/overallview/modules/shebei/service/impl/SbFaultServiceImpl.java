package com.sgcc.bd.overallview.modules.shebei.service.impl;


import com.sgcc.bd.overallview.modules.shebei.service.SbFaultService;
import com.sgcc.bd.overallview.modules.shebei.dao.SbFaultDao;
import com.sgcc.bd.overallview.modules.shebei.entity.SbFault;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @desc 设备履历故障记录表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-15
 */
@Service
public class SbFaultServiceImpl extends ServiceImpl<SbFaultDao, SbFault> implements SbFaultService {

    @Autowired
    SbFaultDao sbFaultDao;

}
