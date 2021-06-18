package cn.exrick.xboot.modules.huanjing.service;

import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.Result;
import cn.exrick.xboot.modules.huanjing.dto.HjEquipmentNumDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.exrick.xboot.modules.huanjing.entity.HjDengguang;


/**
 * @desc 灯光监视表 service
 * @author chenfeixiang
 * @since 2021-06-08
 */
public interface HjDengguangService  extends IService<HjDengguang>{

    HjEquipmentNumDTO getAuxiliaryEquipmentNum(BaseReqVO request);
}
