package cn.exrick.xboot.modules.shebei.query;

import java.time.LocalDateTime;
import cn.exrick.xboot.modules.shebei.entity.SbHiddenDangersCountermeasures;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @desc 隐患反措专项排查表 列表分页查询对象
 * @author chenfeixiang
 * @since 2021-07-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SbHiddenDangersCountermeasures查询对象", description="隐患反措专项排查表查询对象")
public class SbHiddenDangersCountermeasuresQuery extends SbHiddenDangersCountermeasures{








}
