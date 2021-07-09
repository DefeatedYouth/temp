package cn.exrick.xboot.modules.shebei.query;

import java.time.LocalDateTime;
import cn.exrick.xboot.modules.shebei.entity.SbActiveWarning;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @desc 设备主动预警表 列表分页查询对象
 * @author chenfeixiang
 * @since 2021-07-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SbActiveWarning查询对象", description="设备主动预警表查询对象")
public class SbActiveWarningQuery extends SbActiveWarning{














}
