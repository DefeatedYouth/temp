package com.sgcc.bd.overallview.modules.base.service.impl;


import com.sgcc.bd.overallview.modules.base.service.BaseSiteService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sgcc.bd.overallview.modules.base.entity.BaseSite;
import com.sgcc.bd.overallview.modules.base.dao.BaseSiteDao;

/**
 * @desc 站点表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class BaseSiteServiceImpl extends ServiceImpl<BaseSiteDao, BaseSite> implements BaseSiteService {

    @Autowired
    BaseSiteDao baseSiteDao;

}
