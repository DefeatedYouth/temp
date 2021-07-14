package com.sgcc.bd.overallview.modules.base.query;

import com.sgcc.bd.overallview.modules.base.entity.BasePlace;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;

/**
 * @desc  区域地点表列表分页查询对象
 * @author chenfeixiang
 * @since 2021-06-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="BasePlace查询对象", description="区域地点表 查询对象")
public class BasePlaceQuery extends BasePlace{



}
