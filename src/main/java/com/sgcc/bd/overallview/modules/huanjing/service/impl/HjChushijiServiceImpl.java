package com.sgcc.bd.overallview.modules.huanjing.service.impl;


import com.sgcc.bd.overallview.common.enums.EnumLinkState;
import com.sgcc.bd.overallview.common.enums.EnumSwitchState;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.modules.huanjing.dto.HjEquipmentNumDTO;
import com.sgcc.bd.overallview.modules.huanjing.service.HjChushijiService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sgcc.bd.overallview.modules.huanjing.entity.HjChushiji;
import com.sgcc.bd.overallview.modules.huanjing.dao.HjChushijiDao;

/**
 * @desc 除湿机监视表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class HjChushijiServiceImpl extends ServiceImpl<HjChushijiDao, HjChushiji> implements HjChushijiService {

    @Autowired
    HjChushijiDao hjChushijiDao;

    @Override
    public HjEquipmentNumDTO getAuxiliaryEquipmentNum(BaseReqVO request) {
        try {
            HjEquipmentNumDTO hjEquipmentNumDTO = new HjEquipmentNumDTO();
            Integer totalNum = this.count(new QueryWrapper<HjChushiji>().lambda()
                    .eq(HjChushiji::getSiteId, request.getSiteId()));
            hjEquipmentNumDTO.setTotalNum(totalNum);
            Integer openNum = this.count(new QueryWrapper<HjChushiji>().lambda()
                    .eq(HjChushiji::getSiteId, request.getSiteId())
                    .eq(HjChushiji::getWorkState, EnumSwitchState.Open.getValue()));
            hjEquipmentNumDTO.setOpenNum(openNum);
            Integer downNum = this.count(new QueryWrapper<HjChushiji>().lambda()
                    .eq(HjChushiji::getSiteId, request.getSiteId())
                    .eq(HjChushiji::getWorkState, EnumSwitchState.Shut.getValue()));
            hjEquipmentNumDTO.setDownNum(downNum);
            Integer processed = this.count(new QueryWrapper<HjChushiji>().lambda()
                    .eq(HjChushiji::getSiteId, request.getSiteId())
                    .eq(HjChushiji::getLinkState, EnumLinkState.Processed.getValue()));
            hjEquipmentNumDTO.setAbnormalCommunicationNum(processed);
            return  hjEquipmentNumDTO;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
