package com.sgcc.bd.overallview.modules.shebei.service;

import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.modules.shebei.dto.SbDefectDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sgcc.bd.overallview.modules.shebei.entity.SbDanger;


/**
 * @desc 断路器隐患信息表 service
 * @author chenfeixiang
 * @since 2021-06-15
 */
public interface SbDangerService  extends IService<SbDanger>{

    SbDefectDTO getCountDefectNum(BaseReqVO request);
}
