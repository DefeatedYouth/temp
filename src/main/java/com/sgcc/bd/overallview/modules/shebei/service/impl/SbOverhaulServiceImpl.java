package com.sgcc.bd.overallview.modules.shebei.service.impl;


import com.sgcc.bd.overallview.modules.shebei.service.SbOverhaulService;
import com.sgcc.bd.overallview.modules.shebei.dao.SbOverhaulDao;
import com.sgcc.bd.overallview.modules.shebei.entity.SbOverhaul;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @desc 断路器履历检修信息表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-15
 */
@Service
public class SbOverhaulServiceImpl extends ServiceImpl<SbOverhaulDao, SbOverhaul> implements SbOverhaulService {

    @Autowired
    SbOverhaulDao sbOverhaulDao;

}
