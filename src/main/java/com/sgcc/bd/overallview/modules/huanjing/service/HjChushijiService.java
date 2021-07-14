package com.sgcc.bd.overallview.modules.huanjing.service;

import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.modules.huanjing.dto.HjEquipmentNumDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sgcc.bd.overallview.modules.huanjing.entity.HjChushiji;


/**
 * @desc 除湿机监视表 service
 * @author chenfeixiang
 * @since 2021-06-08
 */
public interface HjChushijiService  extends IService<HjChushiji>{

    HjEquipmentNumDTO getAuxiliaryEquipmentNum(BaseReqVO request);
}
