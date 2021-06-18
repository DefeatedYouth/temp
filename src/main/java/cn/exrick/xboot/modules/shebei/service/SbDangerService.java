package cn.exrick.xboot.modules.shebei.service;

import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.Result;
import cn.exrick.xboot.modules.shebei.dto.SbDefectDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.exrick.xboot.modules.shebei.entity.SbDanger;


/**
 * @desc 断路器隐患信息表 service
 * @author chenfeixiang
 * @since 2021-06-15
 */
public interface SbDangerService  extends IService<SbDanger>{

    SbDefectDTO getCountDefectNum(BaseReqVO request);
}
