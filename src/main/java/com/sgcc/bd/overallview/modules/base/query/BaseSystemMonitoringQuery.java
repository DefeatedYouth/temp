package com.sgcc.bd.overallview.modules.base.query;

import com.sgcc.bd.overallview.modules.base.entity.BaseSystemMonitoring;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;

/**
 * @desc 交直流系统监视表 列表分页查询对象
 * @author chenfeixiang
 * @since 2021-06-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="BaseSystemMonitoring查询对象", description="交直流系统监视表查询对象")
public class BaseSystemMonitoringQuery extends BaseSystemMonitoring{








}
