package com.sgcc.bd.overallview.modules.shebei.service.impl;


import com.sgcc.bd.overallview.modules.shebei.service.SbRealdataService;
import com.sgcc.bd.overallview.modules.shebei.dao.SbRealdataDao;
import com.sgcc.bd.overallview.modules.shebei.entity.SbRealdata;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @desc 断路器实时状态数据表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-15
 */
@Service
public class SbRealdataServiceImpl extends ServiceImpl<SbRealdataDao, SbRealdata> implements SbRealdataService {

    @Autowired
    SbRealdataDao sbRealdataDao;

}
