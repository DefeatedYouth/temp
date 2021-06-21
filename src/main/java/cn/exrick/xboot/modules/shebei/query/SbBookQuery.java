package cn.exrick.xboot.modules.shebei.query;

import java.time.LocalDateTime;
import java.util.Date;

import cn.exrick.xboot.modules.shebei.entity.SbBook;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @desc 断路器设备台账 列表分页查询对象
 * @author chenfeixiang
 * @since 2021-06-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SbBook查询对象", description="断路器设备台账查询对象")
public class SbBookQuery extends SbBook{

    @ApiModelProperty(value = "投运日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;
    @ApiModelProperty(value = "投运日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

}
