package cn.exrick.xboot.modules.shebei.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc 断路器sf6监测数据表 实体
 * @author chenfeixiang
 * @since 2021-06-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value="SbSfsix对象", description="断路器sf6监测数据表")
public class SbSfsix extends StmBaseEntity {


    private String resourcesId;

    private Long siteId;

    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    @ApiModelProperty(value = "设备类型")
    private Integer deviceType;

    @ApiModelProperty(value = "监测时间")
    private Date monitoringTime;

    @ApiModelProperty(value = "A相SF6气体浓度")
    private String agasConcentration;

    @ApiModelProperty(value = "A相SF6气体压力")
    private String agasPressure;

    @ApiModelProperty(value = "A相SF6气体水分")
    private String agasMoisture;

    @ApiModelProperty(value = "B相SF6气体浓度")
    private String bgasConcentration;

    @ApiModelProperty(value = "B相SF6气体压力")
    private String bgasPressure;

    @ApiModelProperty(value = "B相SF6气体水分")
    private String bgasMoisture;

    @ApiModelProperty(value = "C相SF6气体浓度")
    private String cgasConcentration;

    @ApiModelProperty(value = "C相SF6气体压力")
    private String cgasPressure;

    @ApiModelProperty(value = "C相SF6气体水分")
    private String cgasMoisture;


}
