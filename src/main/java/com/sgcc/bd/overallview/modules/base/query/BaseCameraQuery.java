package com.sgcc.bd.overallview.modules.base.query;

import com.sgcc.bd.overallview.modules.base.entity.BaseCamera;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;

/**
 * @desc  摄像机表 列表分页查询对象
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="BaseCamera查询对象", description=" 摄像机表查询对象")
public class BaseCameraQuery extends BaseCamera {






}
