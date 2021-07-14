package com.sgcc.bd.overallview.modules.huanjing.service;

import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.modules.huanjing.dto.HjEquipmentNumDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sgcc.bd.overallview.modules.huanjing.entity.HjShuibang;


/**
 * @desc 水泵监视表 service
 * @author chenfeixiang
 * @since 2021-06-08
 */
public interface HjShuibangService  extends IService<HjShuibang>{

    HjEquipmentNumDTO getAuxiliaryEquipmentNum(BaseReqVO request);
}
