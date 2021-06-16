package cn.exrick.xboot.modules.shebei.query;

import java.time.LocalDateTime;
import cn.exrick.xboot.modules.shebei.entity.SbDanger;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @desc 断路器隐患信息表 列表分页查询对象
 * @author chenfeixiang
 * @since 2021-06-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SbDanger查询对象", description="断路器隐患信息表查询对象")
public class SbDangerQuery extends SbDanger{
















}