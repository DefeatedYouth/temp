package com.sgcc.bd.overallview.modules.huanjing.service.impl;


import com.sgcc.bd.overallview.common.enums.EnumLinkState;
import com.sgcc.bd.overallview.common.enums.EnumTemperatureAlarmState;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.modules.huanjing.dto.HjWenduDTO;
import com.sgcc.bd.overallview.modules.huanjing.service.HjShiduService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sgcc.bd.overallview.modules.huanjing.entity.HjShidu;
import com.sgcc.bd.overallview.modules.huanjing.dao.HjShiduDao;

/**
 * @desc 湿度监视表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class HjShiduServiceImpl extends ServiceImpl<HjShiduDao, HjShidu> implements HjShiduService {

    @Autowired
    HjShiduDao hjShiduDao;

    @Override
    public HjWenduDTO temperatureCount(BaseReqVO request) {
        try {
            HjWenduDTO hjWenduDTO = new HjWenduDTO();
            Integer totalNum = this.count(new QueryWrapper<HjShidu>().lambda().eq(HjShidu::getSiteId, request.getSiteId()));
            hjWenduDTO.setTotalNum(totalNum);
            Integer alarmNum = this.count(new QueryWrapper<HjShidu>().lambda()
                    .eq(HjShidu::getSiteId, request.getSiteId())
                    .eq(HjShidu::getAlarmState, EnumTemperatureAlarmState.Alarm.getValue().toString())
            );
            hjWenduDTO.setAlarmNum(alarmNum);
            HjShidu hjShidu = this.getBaseMapper().selectOne(new QueryWrapper<HjShidu>().lambda().eq(HjShidu::getSiteId, request.getSiteId()).orderByAsc(HjShidu::getShiduValue).last("limit 1"));
            hjWenduDTO.setMaximumTemperature(hjShidu.getShiduValue());
            Integer abnormalCommunication = this.count(new QueryWrapper<HjShidu>().lambda().eq(HjShidu::getSiteId, request.getSiteId()).eq(HjShidu::getLinkState, EnumLinkState.Processed.getValue().toString()));
            hjWenduDTO.setAbnormalCommunication(abnormalCommunication);
            return  hjWenduDTO;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
