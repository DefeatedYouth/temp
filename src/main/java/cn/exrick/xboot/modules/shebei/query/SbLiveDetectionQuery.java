package cn.exrick.xboot.modules.shebei.query;

import java.time.LocalDateTime;
import cn.exrick.xboot.modules.shebei.entity.SbLiveDetection;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @desc 设备带电测试记录表 列表分页查询对象
 * @author chenfeixiang
 * @since 2021-06-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SbLiveDetection查询对象", description="设备带电测试记录表查询对象")
public class SbLiveDetectionQuery extends SbLiveDetection{












}
