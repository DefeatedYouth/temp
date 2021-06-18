package cn.exrick.xboot.modules.huanjing.service.impl;


import cn.exrick.xboot.common.enums.EnumAlarmStateType;
import cn.exrick.xboot.common.utils.ResultUtil;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.modules.huanjing.dto.HjEquipmentNumDTO;
import cn.exrick.xboot.modules.huanjing.service.HjShuiweiService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.huanjing.entity.HjShuiwei;
import cn.exrick.xboot.modules.huanjing.dao.HjShuiweiDao;

/**
 * @desc 水位传感器监视表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class HjShuiweiServiceImpl extends ServiceImpl<HjShuiweiDao, HjShuiwei> implements HjShuiweiService {

    @Autowired
    HjShuiweiDao hjShuiweiDao;

    @Override
    public HjEquipmentNumDTO getAuxiliaryEquipmentNum(BaseReqVO request) {
        try {
            HjEquipmentNumDTO hjEquipmentNumDTO = new HjEquipmentNumDTO();
            Integer totalNum = this.count(new QueryWrapper<HjShuiwei>().lambda()
                    .eq(HjShuiwei::getSiteId, request.getSiteId()));
            hjEquipmentNumDTO.setTotalNum(totalNum);
            HjShuiwei hjShuiwei = this.getBaseMapper().selectOne(new QueryWrapper<HjShuiwei>().lambda()
                    .eq(HjShuiwei::getSiteId, request.getSiteId())
                    .orderByAsc(HjShuiwei::getShuiweiValue).last("limit 1"));
            hjEquipmentNumDTO.setWaterLevelMax(hjShuiwei.getShuiweiValue());
            Integer alarmNum = this.count(new QueryWrapper<HjShuiwei>().lambda()
                    .eq(HjShuiwei::getSiteId, request.getSiteId())
                    .eq(HjShuiwei::getAlarmState, EnumAlarmStateType.Processed.getValue()));
            hjEquipmentNumDTO.setAlarmNum(alarmNum);
            return  hjEquipmentNumDTO;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
