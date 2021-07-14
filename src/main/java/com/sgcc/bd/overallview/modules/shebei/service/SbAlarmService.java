package com.sgcc.bd.overallview.modules.shebei.service;

import com.sgcc.bd.overallview.common.vo.BaseReqVO;
import com.sgcc.bd.overallview.modules.shebei.dto.SbAlarmNumDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sgcc.bd.overallview.modules.shebei.entity.SbAlarm;


/**
 * @desc 断路器告警数据表 service
 * @author chenfeixiang
 * @since 2021-06-15
 */
public interface SbAlarmService  extends IService<SbAlarm>{

    SbAlarmNumDTO getAlarmNum(BaseReqVO request);
}
