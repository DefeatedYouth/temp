package cn.exrick.xboot.modules.nj.query;

import java.time.LocalDateTime;
import cn.exrick.xboot.modules.nj.entity.NjDevice;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @desc 主设备表 列表分页查询对象
 * @author chenfeixiang
 * @since 2021-06-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="NjDevice查询对象", description="主设备表查询对象")
public class NjDeviceQuery extends NjDevice{












    @ApiModelProperty(value = "投运日期开始")
    private LocalDateTime runDateBegin;

    @ApiModelProperty(value = "投运日期结束")
    private LocalDateTime runDateEnd;



}
