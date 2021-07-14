package com.sgcc.bd.overallview.modules.shebei.service.impl;


import com.sgcc.bd.overallview.modules.shebei.service.SbBookService;
import com.sgcc.bd.overallview.modules.shebei.dao.SbBookDao;
import com.sgcc.bd.overallview.modules.shebei.entity.SbBook;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @desc 断路器设备台账 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-15
 */
@Service
public class SbBookServiceImpl extends ServiceImpl<SbBookDao, SbBook> implements SbBookService {

    @Autowired
    SbBookDao sbBookDao;

}
