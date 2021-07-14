package com.sgcc.bd.overallview.modules.huanjing.service.impl;


import com.sgcc.bd.overallview.common.enums.EnumLinkState;
import com.sgcc.bd.overallview.common.enums.EnumSwitchState;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.modules.huanjing.dto.HjEquipmentNumDTO;
import com.sgcc.bd.overallview.modules.huanjing.service.HjKongtiaoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sgcc.bd.overallview.modules.huanjing.entity.HjKongtiao;
import com.sgcc.bd.overallview.modules.huanjing.dao.HjKongtiaoDao;

/**
 * @desc 空调监视表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class HjKongtiaoServiceImpl extends ServiceImpl<HjKongtiaoDao, HjKongtiao> implements HjKongtiaoService {

    @Autowired
    HjKongtiaoDao hjKongtiaoDao;

    @Override
    public HjEquipmentNumDTO getAuxiliaryEquipmentNum(BaseReqVO request) {
        try {
            HjEquipmentNumDTO hjEquipmentNumDTO = new HjEquipmentNumDTO();
            Integer totalNum = this.count(new QueryWrapper<HjKongtiao>().lambda()
                    .eq(HjKongtiao::getSiteId, request.getSiteId()));
            hjEquipmentNumDTO.setTotalNum(totalNum);
            Integer openNum = this.count(new QueryWrapper<HjKongtiao>().lambda()
                    .eq(HjKongtiao::getSiteId, request.getSiteId())
                    .eq(HjKongtiao::getSwitchState, EnumSwitchState.Open.getValue()));
            hjEquipmentNumDTO.setOpenNum(openNum);
            Integer downNum = this.count(new QueryWrapper<HjKongtiao>().lambda()
                    .eq(HjKongtiao::getSiteId, request.getSiteId())
                    .eq(HjKongtiao::getSwitchState, EnumSwitchState.Shut.getValue()));
            hjEquipmentNumDTO.setDownNum(downNum);
            Integer processed = this.count(new QueryWrapper<HjKongtiao>().lambda()
                    .eq(HjKongtiao::getSiteId, request.getSiteId())
                    .eq(HjKongtiao::getLinkState, EnumLinkState.Processed.getValue()));
            hjEquipmentNumDTO.setAbnormalCommunicationNum(processed);
            return  hjEquipmentNumDTO;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
