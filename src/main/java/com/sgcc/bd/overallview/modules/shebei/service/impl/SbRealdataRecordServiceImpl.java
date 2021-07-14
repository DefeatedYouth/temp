package com.sgcc.bd.overallview.modules.shebei.service.impl;


import com.sgcc.bd.overallview.modules.shebei.service.SbRealdataRecordService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sgcc.bd.overallview.modules.shebei.entity.SbRealdataRecord;
import com.sgcc.bd.overallview.modules.shebei.dao.SbRealdataRecordDao;

/**
 * @desc 设备实时状态历史数据表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-18
 */
@Service
public class SbRealdataRecordServiceImpl extends ServiceImpl<SbRealdataRecordDao, SbRealdataRecord> implements SbRealdataRecordService {

    @Autowired
    SbRealdataRecordDao sbRealdataRecordDao;

}
