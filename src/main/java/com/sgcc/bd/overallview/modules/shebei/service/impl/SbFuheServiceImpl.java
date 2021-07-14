package com.sgcc.bd.overallview.modules.shebei.service.impl;


import com.sgcc.bd.overallview.modules.shebei.service.SbFuheService;
import com.sgcc.bd.overallview.modules.shebei.dao.SbFuheDao;
import com.sgcc.bd.overallview.modules.shebei.entity.SbFuhe;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @desc 断路器负荷数据表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-15
 */
@Service
public class SbFuheServiceImpl extends ServiceImpl<SbFuheDao, SbFuhe> implements SbFuheService {

    @Autowired
    SbFuheDao sbFuheDao;

}
