package cn.exrick.xboot.modules.huanjing.service.impl;


import cn.exrick.xboot.common.enums.EnumLinkState;
import cn.exrick.xboot.common.enums.EnumTemperatureAlarmState;
import cn.exrick.xboot.common.utils.ResultUtil;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.Result;
import cn.exrick.xboot.modules.huanjing.dto.HjWenduDTO;
import cn.exrick.xboot.modules.huanjing.service.HjWenduService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.huanjing.entity.HjWendu;
import cn.exrick.xboot.modules.huanjing.dao.HjWenduDao;

/**
 * @desc 温度监视表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class HjWenduServiceImpl extends ServiceImpl<HjWenduDao, HjWendu> implements HjWenduService {

    @Autowired
    HjWenduDao hjWenduDao;

    @Override
    public HjWenduDTO temperatureCount(BaseReqVO request) {
        try {
            HjWenduDTO hjWenduDTO = new HjWenduDTO();
            Integer totalNum = this.count(new QueryWrapper<HjWendu>().lambda().eq(HjWendu::getSiteId, request.getSiteId()));
            hjWenduDTO.setTotalNum(totalNum);
            Integer alarmNum = this.count(new QueryWrapper<HjWendu>().lambda()
                    .eq(HjWendu::getSiteId, request.getSiteId())
                    .eq(HjWendu::getAlarmState, EnumTemperatureAlarmState.Alarm.getValue())
            );
            hjWenduDTO.setAlarmNum(alarmNum);
            HjWendu hjWendus = this.getBaseMapper().selectOne(new QueryWrapper<HjWendu>().lambda().eq(HjWendu::getSiteId, request.getSiteId()).orderByAsc(HjWendu::getWenduValue).last("limit 1"));
            hjWenduDTO.setMaximumTemperature(hjWendus.getWenduValue());
            Integer abnormalCommunication = this.count(new QueryWrapper<HjWendu>().lambda().eq(HjWendu::getSiteId, request.getSiteId()).eq(HjWendu::getLinkState, EnumLinkState.Processed.getValue()));
            hjWenduDTO.setAbnormalCommunication(abnormalCommunication);
            return  hjWenduDTO;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
