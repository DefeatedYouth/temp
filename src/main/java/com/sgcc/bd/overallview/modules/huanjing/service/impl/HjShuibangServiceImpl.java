package com.sgcc.bd.overallview.modules.huanjing.service.impl;


import com.sgcc.bd.overallview.common.enums.EnumLinkState;
import com.sgcc.bd.overallview.common.enums.EnumSwitchState;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.modules.huanjing.dto.HjEquipmentNumDTO;
import com.sgcc.bd.overallview.modules.huanjing.service.HjShuibangService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sgcc.bd.overallview.modules.huanjing.entity.HjShuibang;
import com.sgcc.bd.overallview.modules.huanjing.dao.HjShuibangDao;

/**
 * @desc 水泵监视表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class HjShuibangServiceImpl extends ServiceImpl<HjShuibangDao, HjShuibang> implements HjShuibangService {

    @Autowired
    HjShuibangDao hjShuibangDao;


    @Override
    public HjEquipmentNumDTO getAuxiliaryEquipmentNum(BaseReqVO request) {
        try {
            HjEquipmentNumDTO hjEquipmentNumDTO = new HjEquipmentNumDTO();
            Integer totalNum = this.count(new QueryWrapper<HjShuibang>().lambda()
                    .eq(HjShuibang::getSiteId, request.getSiteId()));
            hjEquipmentNumDTO.setTotalNum(totalNum);
            Integer openNum = this.count(new QueryWrapper<HjShuibang>().lambda()
                    .eq(HjShuibang::getSiteId, request.getSiteId())
                    .eq(HjShuibang::getSwitchState, EnumSwitchState.Open.getValue().toString()));
            hjEquipmentNumDTO.setOpenNum(openNum);
            Integer downNum = this.count(new QueryWrapper<HjShuibang>().lambda()
                    .eq(HjShuibang::getSiteId, request.getSiteId())
                    .eq(HjShuibang::getSwitchState, EnumSwitchState.Shut.getValue().toString()));
            hjEquipmentNumDTO.setDownNum(downNum);
            Integer processed = this.count(new QueryWrapper<HjShuibang>().lambda()
                    .eq(HjShuibang::getSiteId, request.getSiteId())
                    .eq(HjShuibang::getLinkState, EnumLinkState.Processed.getValue().toString()));
            hjEquipmentNumDTO.setAbnormalCommunicationNum(processed);
            return hjEquipmentNumDTO;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
