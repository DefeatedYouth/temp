package com.sgcc.bd.overallview.modules.shebei.service.impl;


import com.sgcc.bd.overallview.modules.shebei.service.SbTestService;
import com.sgcc.bd.overallview.modules.shebei.dao.SbTestDao;
import com.sgcc.bd.overallview.modules.shebei.entity.SbTest;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @desc 断路器履历实验信息表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-15
 */
@Service
public class SbTestServiceImpl extends ServiceImpl<SbTestDao, SbTest> implements SbTestService {

    @Autowired
    SbTestDao sbTestDao;

}
