package com.sgcc.bd.overallview.modules.huanjing.service;

import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.modules.huanjing.dto.HjEquipmentNumDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sgcc.bd.overallview.modules.huanjing.entity.HjShuisheng;


/**
 * @desc 水浸传感器监视表 service
 * @author chenfeixiang
 * @since 2021-06-08
 */
public interface HjShuishengService  extends IService<HjShuisheng>{

    HjEquipmentNumDTO getAuxiliaryEquipmentNum(BaseReqVO request);
}
