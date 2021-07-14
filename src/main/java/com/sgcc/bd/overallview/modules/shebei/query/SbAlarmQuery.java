package com.sgcc.bd.overallview.modules.shebei.query;

import com.sgcc.bd.overallview.modules.shebei.entity.SbAlarm;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;

/**
 * @desc 设备告警数据表 列表分页查询对象
 * @author chenfeixiang
 * @since 2021-07-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SbAlarm查询对象", description="设备告警数据表查询对象")
public class SbAlarmQuery extends SbAlarm{













}
