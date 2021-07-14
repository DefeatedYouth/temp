package com.sgcc.bd.overallview.modules.huanjing.service.impl;


import com.sgcc.bd.overallview.common.enums.EnumAlarmStateType;
import com.sgcc.bd.overallview.common.enums.EnumLinkState;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.modules.huanjing.dto.HjEquipmentNumDTO;
import com.sgcc.bd.overallview.modules.huanjing.service.HjSfsexService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sgcc.bd.overallview.modules.huanjing.entity.HjSfsex;
import com.sgcc.bd.overallview.modules.huanjing.dao.HjSfsexDao;

/**
 * @desc SF6监视表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class HjSfsexServiceImpl extends ServiceImpl<HjSfsexDao, HjSfsex> implements HjSfsexService {

    @Autowired
    HjSfsexDao hjSfsexDao;

    @Override
    public HjEquipmentNumDTO getAuxiliaryEquipmentNum(BaseReqVO request) {
        try {
            HjEquipmentNumDTO hjEquipmentNumDTO = new HjEquipmentNumDTO();
            Integer totalNum = this.count(new QueryWrapper<HjSfsex>().lambda()
                    .eq(HjSfsex::getSiteId, request.getSiteId()));
            hjEquipmentNumDTO.setTotalNum(totalNum);
            HjSfsex sfsix = this.getBaseMapper().selectOne(new QueryWrapper<HjSfsex>().lambda()
                    .eq(HjSfsex::getSiteId, request.getSiteId()).orderByAsc(HjSfsex::getSfsexValue).last("limit 1"));
            hjEquipmentNumDTO.setSfSixMax(sfsix.getSfsexValue());
            HjSfsex cotwo = this.getBaseMapper().selectOne(new QueryWrapper<HjSfsex>().lambda()
                    .eq(HjSfsex::getSiteId, request.getSiteId()).orderByAsc(HjSfsex::getOtwoValue).last("limit 1"));
            hjEquipmentNumDTO.setCotwoMax(cotwo.getOtwoValue());
            Integer processed = this.count(new QueryWrapper<HjSfsex>().lambda()
                    .eq(HjSfsex::getSiteId, request.getSiteId())
                    .eq(HjSfsex::getLinkState, EnumLinkState.Processed.getValue()));
            hjEquipmentNumDTO.setAbnormalCommunicationNum(processed);
            Integer alarmNum = this.count(new QueryWrapper<HjSfsex>().lambda()
                    .eq(HjSfsex::getSiteId, request.getSiteId())
                    .eq(HjSfsex::getAlarmState, EnumAlarmStateType.Processed.getValue()));
            hjEquipmentNumDTO.setAlarmNum(alarmNum);
            return  hjEquipmentNumDTO;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
