package cn.exrick.xboot.modules.anxiaofang.query;

import java.time.LocalDateTime;
import cn.exrick.xboot.modules.anxiaofang.entity.AxfDevice;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @desc 安消防设备监视表 列表分页查询对象
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="AxfDevice查询对象", description="安消防设备监视表查询对象")
public class AxfDeviceQuery extends AxfDevice{











}
