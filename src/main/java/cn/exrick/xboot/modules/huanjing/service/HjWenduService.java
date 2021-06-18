package cn.exrick.xboot.modules.huanjing.service;

import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.Result;
import cn.exrick.xboot.modules.huanjing.dto.HjWenduDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.exrick.xboot.modules.huanjing.entity.HjWendu;


/**
 * @desc 温度监视表 service
 * @author chenfeixiang
 * @since 2021-06-08
 */
public interface HjWenduService  extends IService<HjWendu>{

    HjWenduDTO temperatureCount(BaseReqVO request);
}
