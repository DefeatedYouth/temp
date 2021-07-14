package com.sgcc.bd.overallview.modules.shebei.service.impl;


import com.sgcc.bd.overallview.modules.shebei.service.SbHiddenDangersCountermeasuresService;
import com.sgcc.bd.overallview.modules.shebei.dao.SbHiddenDangersCountermeasuresDao;
import com.sgcc.bd.overallview.modules.shebei.entity.SbHiddenDangersCountermeasures;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @desc 隐患反措专项排查表 serviceImpl
 * @author chenfeixiang
 * @since 2021-07-07
 */
@Service
public class SbHiddenDangersCountermeasuresServiceImpl extends ServiceImpl<SbHiddenDangersCountermeasuresDao, SbHiddenDangersCountermeasures> implements SbHiddenDangersCountermeasuresService {

    @Autowired
    SbHiddenDangersCountermeasuresDao sbHiddenDangersCountermeasuresDao;

}
