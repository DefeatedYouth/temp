package cn.exrick.xboot.modules.shebei.service;

import cn.exrick.xboot.common.vo.BaseReqVO;
import cn.exrick.xboot.common.vo.Result;
import cn.exrick.xboot.modules.shebei.dto.SbAlarmNumDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.exrick.xboot.modules.shebei.entity.SbAlarm;


/**
 * @desc 断路器告警数据表 service
 * @author chenfeixiang
 * @since 2021-06-15
 */
public interface SbAlarmService  extends IService<SbAlarm>{

    SbAlarmNumDTO getAlarmNum(BaseReqVO request);
}
