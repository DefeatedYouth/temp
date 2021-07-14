package com.sgcc.bd.overallview.modules.huanjing.service;

import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.modules.huanjing.dto.HjEquipmentNumDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sgcc.bd.overallview.modules.huanjing.entity.HjKongtiao;


/**
 * @desc 空调监视表 service
 * @author chenfeixiang
 * @since 2021-06-08
 */
public interface HjKongtiaoService  extends IService<HjKongtiao>{

    HjEquipmentNumDTO getAuxiliaryEquipmentNum(BaseReqVO request);
}
