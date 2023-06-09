package com.sgcc.bd.overallview.modules.huanjing.service.impl;


import com.sgcc.bd.overallview.common.enums.EnumLinkState;
import com.sgcc.bd.overallview.common.enums.EnumSwitchState;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.modules.huanjing.dto.HjEquipmentNumDTO;
import com.sgcc.bd.overallview.modules.huanjing.service.HjDengguangService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sgcc.bd.overallview.modules.huanjing.entity.HjDengguang;
import com.sgcc.bd.overallview.modules.huanjing.dao.HjDengguangDao;

/**
 * @desc 灯光监视表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class HjDengguangServiceImpl extends ServiceImpl<HjDengguangDao, HjDengguang> implements HjDengguangService {

    @Autowired
    HjDengguangDao hjDengguangDao;

    @Override
    public HjEquipmentNumDTO getAuxiliaryEquipmentNum(BaseReqVO request) {
        try {
            HjEquipmentNumDTO hjEquipmentNumDTO = new HjEquipmentNumDTO();
            Integer totalNum = this.count(new QueryWrapper<HjDengguang>().lambda()
                    .eq(HjDengguang::getSiteId, request.getSiteId()));
            hjEquipmentNumDTO.setTotalNum(totalNum);
            Integer openNum = this.count(new QueryWrapper<HjDengguang>().lambda()
                    .eq(HjDengguang::getSiteId, request.getSiteId())
                    .eq(HjDengguang::getSwitchState, EnumSwitchState.Open.getValue().toString()));
            hjEquipmentNumDTO.setOpenNum(openNum);
            Integer downNum = this.count(new QueryWrapper<HjDengguang>().lambda()
                    .eq(HjDengguang::getSiteId, request.getSiteId())
                    .eq(HjDengguang::getSwitchState, EnumSwitchState.Shut.getValue().toString()));
            hjEquipmentNumDTO.setDownNum(downNum);
            Integer processed = this.count(new QueryWrapper<HjDengguang>().lambda()
                    .eq(HjDengguang::getSiteId, request.getSiteId())
                    .eq(HjDengguang::getLinkState, EnumLinkState.Processed.getValue().toString()));
            hjEquipmentNumDTO.setAbnormalCommunicationNum(processed);
            return hjEquipmentNumDTO;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
