package com.sgcc.bd.overallview.modules.shebei.service;

import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.modules.shebei.dto.SbDefectDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sgcc.bd.overallview.modules.shebei.entity.SbDefect;


/**
 * @desc 断路器缺陷信息表 service
 * @author chenfeixiang
 * @since 2021-06-15
 */
public interface SbDefectService  extends IService<SbDefect>{

    SbDefectDTO getCountDefectNum(BaseReqVO request);
}
