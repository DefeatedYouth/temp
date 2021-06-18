package cn.exrick.xboot.modules.huanjing.service;

import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.modules.huanjing.dto.HjEquipmentNumDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.exrick.xboot.modules.huanjing.entity.HjShuibang;


/**
 * @desc 水泵监视表 service
 * @author chenfeixiang
 * @since 2021-06-08
 */
public interface HjShuibangService  extends IService<HjShuibang>{

    HjEquipmentNumDTO getAuxiliaryEquipmentNum(BaseReqVO request);
}
