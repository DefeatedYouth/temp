package com.sgcc.bd.overallview.modules.huanjing.service;

import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.modules.huanjing.dto.HjEquipmentNumDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sgcc.bd.overallview.modules.huanjing.entity.HjFengji;


/**
 * @desc 风机监视表 service
 * @author chenfeixiang
 * @since 2021-06-08
 */
public interface HjFengjiService  extends IService<HjFengji>{

   HjEquipmentNumDTO getAuxiliaryEquipmentNum(BaseReqVO request);
}
