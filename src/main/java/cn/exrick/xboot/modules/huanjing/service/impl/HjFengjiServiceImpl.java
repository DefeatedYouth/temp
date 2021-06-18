package cn.exrick.xboot.modules.huanjing.service.impl;


import cn.exrick.xboot.common.enums.EnumLinkState;
import cn.exrick.xboot.common.enums.EnumSwitchState;
import cn.exrick.xboot.common.utils.ResultUtil;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.modules.huanjing.dto.HjEquipmentNumDTO;
import cn.exrick.xboot.modules.huanjing.service.HjFengjiService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.huanjing.entity.HjFengji;
import cn.exrick.xboot.modules.huanjing.dao.HjFengjiDao;

/**
 * @desc 风机监视表 serviceImpl
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Service
public class HjFengjiServiceImpl extends ServiceImpl<HjFengjiDao, HjFengji> implements HjFengjiService {

    @Autowired
    HjFengjiDao hjFengjiDao;

    @Override
    public HjEquipmentNumDTO getAuxiliaryEquipmentNum(BaseReqVO request) {
        try {
            HjEquipmentNumDTO hjEquipmentNumDTO = new HjEquipmentNumDTO();
            Integer totalNum = this.count(new QueryWrapper<HjFengji>().lambda()
                    .eq(HjFengji::getSiteId, request.getSiteId()));
            hjEquipmentNumDTO.setTotalNum(totalNum);
            Integer processed = this.count(new QueryWrapper<HjFengji>().lambda()
                    .eq(HjFengji::getSiteId, request.getSiteId())
                    .eq(HjFengji::getLinkState, EnumLinkState.Processed.getValue()));
            hjEquipmentNumDTO.setAbnormalCommunicationNum(processed);
            Integer shutNum = this.count(new QueryWrapper<HjFengji>().lambda()
                    .eq(HjFengji::getSiteId, request.getSiteId())
                    .eq(HjFengji::getFengjiState, EnumSwitchState.Shut.getValue()));
            hjEquipmentNumDTO.setDownNum(shutNum);
            return  hjEquipmentNumDTO;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
