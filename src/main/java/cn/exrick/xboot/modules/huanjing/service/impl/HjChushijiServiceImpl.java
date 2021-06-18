package cn.exrick.xboot.modules.huanjing.service.impl;


import cn.exrick.xboot.common.enums.EnumLinkState;
import cn.exrick.xboot.common.enums.EnumSwitchState;
import cn.exrick.xboot.common.utils.ResultUtil;
import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.modules.huanjing.dto.HjEquipmentNumDTO;
import cn.exrick.xboot.modules.huanjing.service.HjChushijiService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.exrick.xboot.modules.huanjing.entity.HjChushiji;
import cn.exrick.xboot.modules.huanjing.dao.HjChushijiDao;

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
