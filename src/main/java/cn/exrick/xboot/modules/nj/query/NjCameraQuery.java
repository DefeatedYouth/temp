package cn.exrick.xboot.modules.nj.query;

import java.time.LocalDateTime;
import cn.exrick.xboot.modules.nj.entity.NjCamera;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @desc  摄像机表 列表分页查询对象
 * @author chenfeixiang
 * @since 2021-06-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="NjCamera查询对象", description=" 摄像机表查询对象")
public class NjCameraQuery extends NjCamera{





}
