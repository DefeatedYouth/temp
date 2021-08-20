package com.sgcc.bd.overallview.modules.huanjing.service.impl;


import com.sgcc.bd.overallview.common.enums.EnumAlarmStateType;
import com.sgcc.bd.overallview.common.enums.EnumLinkState;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.modules.huanjing.dto.HjEquipmentNumDTO;
import com.sgcc.bd.overallview.modules.huanjing.service.HjShuishengService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sgcc.bd.overallview.modules.huanjing.entity.HjShuisheng;
import com.sgcc.bd.overallview.modules.huanjing.dao.HjShuishengDao;

/**
 * @desc 水浸传感器监视表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class HjShuishengServiceImpl extends ServiceImpl<HjShuishengDao, HjShuisheng> implements HjShuishengService {

    @Autowired
    HjShuishengDao hjShuishengDao;

    @Override
    public HjEquipmentNumDTO getAuxiliaryEquipmentNum(BaseReqVO request) {
        try {
            HjEquipmentNumDTO hjEquipmentNumDTO = new HjEquipmentNumDTO();
            Integer totalNum = this.count(new QueryWrapper<HjShuisheng>().lambda()
                    .eq(HjShuisheng::getSiteId, request.getSiteId()));
            hjEquipmentNumDTO.setTotalNum(totalNum);
            Integer linkStateNum = this.count(new QueryWrapper<HjShuisheng>().lambda()
                    .eq(HjShuisheng::getSiteId, request.getSiteId())
                    .eq(HjShuisheng::getLinkState, EnumLinkState.Processed.getValue().toString()));
            hjEquipmentNumDTO.setAbnormalCommunicationNum(linkStateNum);
            Integer alarmNum = this.count(new QueryWrapper<HjShuisheng>().lambda()
                    .eq(HjShuisheng::getSiteId, request.getSiteId())
                    .eq(HjShuisheng::getAlarmState, EnumAlarmStateType.Processed.getValue().toString()));
            hjEquipmentNumDTO.setAlarmNum(alarmNum);
            return hjEquipmentNumDTO;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
