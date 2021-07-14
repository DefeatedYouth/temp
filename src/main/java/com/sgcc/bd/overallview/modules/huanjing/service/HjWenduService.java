package com.sgcc.bd.overallview.modules.huanjing.service;

import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.modules.huanjing.dto.HjWenduDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sgcc.bd.overallview.modules.huanjing.entity.HjWendu;


/**
 * @desc 温度监视表 service
 * @author chenfeixiang
 * @since 2021-06-08
 */
public interface HjWenduService  extends IService<HjWendu>{

    HjWenduDTO temperatureCount(BaseReqVO request);
}
