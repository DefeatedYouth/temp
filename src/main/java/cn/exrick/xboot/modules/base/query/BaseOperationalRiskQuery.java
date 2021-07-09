package cn.exrick.xboot.modules.base.query;

import java.time.LocalDateTime;
import cn.exrick.xboot.modules.base.entity.BaseOperationalRisk;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @desc 操作风险表 列表分页查询对象
 * @author chenfeixiang
 * @since 2021-07-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="BaseOperationalRisk查询对象", description="操作风险表查询对象")
public class BaseOperationalRiskQuery extends BaseOperationalRisk{










}
