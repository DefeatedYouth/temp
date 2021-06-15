package cn.exrick.xboot.modules.shebei.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc 断路器负荷数据表 实体
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
@ApiModel(value="SbFuhe对象", description="断路器负荷数据表")
public class SbFuhe extends StmBaseEntity {


    private String resourcesId;

    private Long siteId;

    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    @ApiModelProperty(value = "监测时间")
    private Date monitoringTime;

    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    @ApiModelProperty(value = "A相电压")
    private String avoltage;

    @ApiModelProperty(value = "B相电压")
    private String bvoltage;

    @ApiModelProperty(value = "C相电压")
    private String cvoltage;

    @ApiModelProperty(value = "A相电流")
    private String aelectric;

    @ApiModelProperty(value = "B相电流")
    private String belectric;

    @ApiModelProperty(value = "C相电流")
    private String celectric;


}
