package cn.exrick.xboot.modules.huanjing.service;

import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.Result;
import cn.exrick.xboot.modules.huanjing.dto.HjEquipmentNumDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.exrick.xboot.modules.huanjing.entity.HjFengji;


/**
 * @desc 风机监视表 service
 * @author chenfeixiang
 * @since 2021-06-08
 */
public interface HjFengjiService  extends IService<HjFengji>{

   HjEquipmentNumDTO getAuxiliaryEquipmentNum(BaseReqVO request);
}
