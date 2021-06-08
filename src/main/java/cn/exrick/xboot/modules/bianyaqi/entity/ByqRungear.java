package cn.exrick.xboot.modules.bianyaqi.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc 变压器运行档位表 实体
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value="ByqRungear对象", description="变压器运行档位表")
public class ByqRungear extends StmBaseEntity {


    private String resourcesId;

    private String siteId;

    @ApiModelProperty(value = "发生时间")
    private Date happenTime;

    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    @ApiModelProperty(value = "挡位")
    private String gear;

    @ApiModelProperty(value = "挡位值")
    private Integer gearValue;


}
