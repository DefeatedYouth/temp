package cn.exrick.xboot.modules.shebei.query;

import java.time.LocalDateTime;
import cn.exrick.xboot.modules.shebei.entity.SbYousepu;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @desc 设备油色谱表 列表分页查询对象
 * @author chenfeixiang
 * @since 2021-06-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SbYousepu查询对象", description="设备油色谱表查询对象")
public class SbYousepuQuery extends SbYousepu{
















}
