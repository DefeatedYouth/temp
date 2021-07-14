package com.sgcc.bd.overallview.modules.base.query;

import com.sgcc.bd.overallview.modules.base.entity.BaseDevice;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;

/**
 * @desc 主设备表 列表分页查询对象
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="BaseDevice查询对象", description="主设备表查询对象")
public class BaseDeviceQuery extends BaseDevice {














}
