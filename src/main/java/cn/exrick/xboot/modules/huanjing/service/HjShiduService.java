package cn.exrick.xboot.modules.huanjing.service;

import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.Result;
import cn.exrick.xboot.modules.huanjing.dto.HjWenduDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.exrick.xboot.modules.huanjing.entity.HjShidu;


/**
 * @desc 湿度监视表 service
 * @author chenfeixiang
 * @since 2021-06-08
 */
public interface HjShiduService  extends IService<HjShidu>{

    HjWenduDTO temperatureCount(BaseReqVO request);
}
