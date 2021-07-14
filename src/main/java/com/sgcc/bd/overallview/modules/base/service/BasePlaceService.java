package com.sgcc.bd.overallview.modules.base.service;

import com.sgcc.bd.overallview.common.vo.MunicipalCompanyVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sgcc.bd.overallview.modules.base.entity.BasePlace;

import java.util.List;


/**
 * @desc  service
 * @author chenfeixiang
 * @since 2021-06-10
 */
public interface BasePlaceService  extends IService<BasePlace>{

    List<BasePlace> getMunicipalCompany(MunicipalCompanyVO municipalCompanyVO);
}
