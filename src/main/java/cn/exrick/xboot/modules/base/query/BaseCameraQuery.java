package cn.exrick.xboot.modules.base.query;

import java.time.LocalDateTime;
import cn.exrick.xboot.modules.base.entity.BaseCamera;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
public class BaseCameraQuery extends BaseCamera{






}
