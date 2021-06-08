package cn.exrick.xboot.modules.duanluqi.query;

import java.time.LocalDateTime;
import cn.exrick.xboot.modules.duanluqi.entity.DlqDanger;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @desc 断路器隐患信息表 列表分页查询对象
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="DlqDanger查询对象", description="断路器隐患信息表查询对象")
public class DlqDangerQuery extends DlqDanger{















}
