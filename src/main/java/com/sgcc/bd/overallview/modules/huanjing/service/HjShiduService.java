package com.sgcc.bd.overallview.modules.huanjing.service;

import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.modules.huanjing.dto.HjWenduDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sgcc.bd.overallview.modules.huanjing.entity.HjShidu;


/**
 * @desc 湿度监视表 service
 * @author chenfeixiang
 * @since 2021-06-08
 */
public interface HjShiduService  extends IService<HjShidu>{

    HjWenduDTO temperatureCount(BaseReqVO request);
}
