package com.sgcc.bd.overallview.modules.shebei.service.impl;


import com.sgcc.bd.overallview.common.enums.EnumAlarmStateType;
import com.sgcc.bd.overallview.common.enums.EnumAlarmType;
import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.modules.shebei.dto.SbAlarmNumDTO;
import com.sgcc.bd.overallview.modules.shebei.service.SbAlarmService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sgcc.bd.overallview.modules.shebei.dao.SbAlarmDao;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sgcc.bd.overallview.modules.shebei.entity.SbAlarm;

/**
 * @desc 断路器告警数据表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-15
 */
@Service
public class SbAlarmServiceImpl extends ServiceImpl<SbAlarmDao, SbAlarm> implements SbAlarmService {

    @Autowired
    SbAlarmDao sbAlarmDao;

    @Override
    public SbAlarmNumDTO getAlarmNum(BaseReqVO request) {
        try {
            SbAlarmNumDTO sbAlarmNumDTO =new SbAlarmNumDTO();
            Integer accidentAlarmNum = this.count(new QueryWrapper<SbAlarm>().lambda()
                    .eq(SbAlarm::getAlarmType, request.getType())
                    .eq(SbAlarm::getAlarmType, EnumAlarmType.Accident.getValue())
                    .eq(SbAlarm::getAlarmState, EnumAlarmStateType.Untreated.getValue())
                    .eq(SbAlarm::getSiteId,request.getSiteId())
            );

            Integer unhandledNum = this.count(new QueryWrapper<SbAlarm>().lambda().eq(SbAlarm::getAlarmType, EnumAlarmType.Accident.getValue())
                    .eq(SbAlarm::getAlarmState, EnumAlarmStateType.Untreated.getValue())
                    .eq(SbAlarm::getSiteId,request.getSiteId())
            );
            sbAlarmNumDTO.setAccidentAlarmNum(accidentAlarmNum);
            sbAlarmNumDTO.setUnhandledNum(unhandledNum);
            return  sbAlarmNumDTO;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
