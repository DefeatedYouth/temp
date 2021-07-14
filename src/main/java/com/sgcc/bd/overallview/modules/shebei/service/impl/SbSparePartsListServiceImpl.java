package com.sgcc.bd.overallview.modules.shebei.service.impl;


import com.sgcc.bd.overallview.modules.shebei.service.SbSparePartsListService;
import com.sgcc.bd.overallview.modules.shebei.dao.SbSparePartsListDao;
import com.sgcc.bd.overallview.modules.shebei.entity.SbSparePartsList;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @desc 备品备件表 serviceImpl
 * @author chenfeixiang
 * @since 2021-07-07
 */
@Service
public class SbSparePartsListServiceImpl extends ServiceImpl<SbSparePartsListDao, SbSparePartsList> implements SbSparePartsListService {

    @Autowired
    SbSparePartsListDao sbSparePartsListDao;

}
