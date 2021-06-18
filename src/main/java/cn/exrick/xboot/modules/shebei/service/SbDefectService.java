package cn.exrick.xboot.modules.shebei.service;

import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.Result;
import cn.exrick.xboot.modules.shebei.dto.SbDefectDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.exrick.xboot.modules.shebei.entity.SbDefect;


/**
 * @desc 断路器缺陷信息表 service
 * @author chenfeixiang
 * @since 2021-06-15
 */
public interface SbDefectService  extends IService<SbDefect>{

    SbDefectDTO getCountDefectNum(BaseReqVO request);
}
