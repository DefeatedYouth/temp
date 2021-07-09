package cn.exrick.xboot.modules.base.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc 气象预警 实体
 * @author chenfeixiang
 * @since 2021-07-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value="BaseMeteorologicalWarning对象", description="气象预警")
public class BaseMeteorologicalWarning extends StmBaseEntity {


    private Long siteId;

    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    @ApiModelProperty(value = "城市")
    private String city;

    @ApiModelProperty(value = "大风")
    private String type;

    @ApiModelProperty(value = "级别")
    private Integer level;

    @ApiModelProperty(value = "内容")
    private String text;

    @ApiModelProperty(value = "起报时间")
    private Date startingTime;

    @ApiModelProperty(value = "预计起报时间")
    private Date forecastStartTime;

    @ApiModelProperty(value = "预计结报时间")
    private Date forecastEndTime;


}
