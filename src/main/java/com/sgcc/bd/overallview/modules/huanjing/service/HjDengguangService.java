package com.sgcc.bd.overallview.modules.huanjing.service;

import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.modules.huanjing.dto.HjEquipmentNumDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sgcc.bd.overallview.modules.huanjing.entity.HjDengguang;


/**
 * @desc 灯光监视表 service
 * @author chenfeixiang
 * @since 2021-06-08
 */
public interface HjDengguangService  extends IService<HjDengguang>{

    HjEquipmentNumDTO getAuxiliaryEquipmentNum(BaseReqVO request);
}
