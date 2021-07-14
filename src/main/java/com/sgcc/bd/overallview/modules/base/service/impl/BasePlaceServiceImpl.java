package com.sgcc.bd.overallview.modules.base.service.impl;


import com.sgcc.bd.overallview.common.vo.MunicipalCompanyVO;
import com.sgcc.bd.overallview.modules.base.service.BasePlaceService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sgcc.bd.overallview.modules.base.dao.BasePlaceDao;
import com.sgcc.bd.overallview.modules.base.entity.BasePlace;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * @desc  serviceImpl
 * @author chenfeixiang
 * @since 2021-06-10
 */
@Service
public class BasePlaceServiceImpl extends ServiceImpl<BasePlaceDao, BasePlace> implements BasePlaceService {

    @Autowired
    BasePlaceDao basePlaceDao;

    @Override
    public List<BasePlace> getMunicipalCompany(MunicipalCompanyVO municipalCompanyVO) {

        try {
            List<BasePlace> basePlaces =
                    this.getBaseMapper().selectList(new QueryWrapper<BasePlace>().lambda()
                            .eq(BasePlace::getLevel, municipalCompanyVO.getLevel())
                            .eq(municipalCompanyVO.getParentId()!=null&&!municipalCompanyVO.getParentId().equals(""),BasePlace::getParentId,municipalCompanyVO.getParentId())
                          //  .eq(municipalCompanyVO.getVoltageLevel()!=null&&!municipalCompanyVO.getVoltageLevel().equals(""),BasePlace::getVoltageLevel,municipalCompanyVO.getVoltageLevel())
                    );
            return basePlaces;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
