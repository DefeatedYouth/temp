package cn.exrick.xboot.modules.bianyaqi.query;

import java.time.LocalDateTime;
import cn.exrick.xboot.modules.bianyaqi.entity.ByqFault;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @desc 设备履历故障记录表 列表分页查询对象
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="ByqFault查询对象", description="设备履历故障记录表查询对象")
public class ByqFaultQuery extends ByqFault{












}
