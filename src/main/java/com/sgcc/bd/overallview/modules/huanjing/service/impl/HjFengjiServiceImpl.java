package com.sgcc.bd.overallview.modules.huanjing.service.impl;


import com.sgcc.bd.overallview.common.enums.EnumLinkState;
import com.sgcc.bd.overallview.common.enums.EnumSwitchState;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.modules.huanjing.dto.HjEquipmentNumDTO;
import com.sgcc.bd.overallview.modules.huanjing.service.HjFengjiService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sgcc.bd.overallview.modules.huanjing.entity.HjFengji;
import com.sgcc.bd.overallview.modules.huanjing.dao.HjFengjiDao;

/**
 * @desc 风机监视表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class HjFengjiServiceImpl extends ServiceImpl<HjFengjiDao, HjFengji> implements HjFengjiService {

    @Autowired
    HjFengjiDao hjFengjiDao;

    @Override
    public HjEquipmentNumDTO getAuxiliaryEquipmentNum(BaseReqVO request) {
        try {
            HjEquipmentNumDTO hjEquipmentNumDTO = new HjEquipmentNumDTO();
            Integer totalNum = this.count(new QueryWrapper<HjFengji>().lambda()
                    .eq(HjFengji::getSiteId, request.getSiteId()));
            hjEquipmentNumDTO.setTotalNum(totalNum);
            Integer processed = this.count(new QueryWrapper<HjFengji>().lambda()
                    .eq(HjFengji::getSiteId, request.getSiteId())
                    .eq(HjFengji::getLinkState, EnumLinkState.Processed.getValue().toString()));
            hjEquipmentNumDTO.setAbnormalCommunicationNum(processed);
            Integer shutNum = this.count(new QueryWrapper<HjFengji>().lambda()
                    .eq(HjFengji::getSiteId, request.getSiteId())
                    .eq(HjFengji::getFengjiState, EnumSwitchState.Shut.getValue().toString()));
            hjEquipmentNumDTO.setDownNum(shutNum);
            return  hjEquipmentNumDTO;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
