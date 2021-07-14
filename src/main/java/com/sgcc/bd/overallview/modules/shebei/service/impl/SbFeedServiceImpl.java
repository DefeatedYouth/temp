package com.sgcc.bd.overallview.modules.shebei.service.impl;


import com.sgcc.bd.overallview.modules.shebei.service.SbFeedService;
import com.sgcc.bd.overallview.modules.shebei.dao.SbFeedDao;
import com.sgcc.bd.overallview.modules.shebei.entity.SbFeed;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @desc 断路器状态评价数据数据表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-15
 */
@Service
public class SbFeedServiceImpl extends ServiceImpl<SbFeedDao, SbFeed> implements SbFeedService {

    @Autowired
    SbFeedDao sbFeedDao;

}
