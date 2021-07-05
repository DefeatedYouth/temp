package cn.exrick.xboot.modules.shebei.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc 设备实时状态历史数据表 实体
 * @author chenfeixiang
 * @since 2021-06-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value="SbRealdataRecord对象", description="设备实时状态历史数据表")
public class SbRealdataRecord extends StmBaseEntity {


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

    @ApiModelProperty(value = "开合状态")
    private Integer openingClosingState;

    @ApiModelProperty(value = "运行档位")
    private Integer operatingGear;

    @ApiModelProperty(value = "挡位值")
    private String gearPosition;

    @ApiModelProperty(value = "A相位绕组温度")
    private String awindingTemperature;

    @ApiModelProperty(value = "A相顶层油温1")
    private String atopOilTemperatureOne;

    @ApiModelProperty(value = "A相顶层油温2")
    private String atopOilTemperatureTwo;

    @ApiModelProperty(value = "A相铁芯接地电流")
    private String acoreGroundingCurrent;

    @ApiModelProperty(value = "B相位绕组温度")
    private String bwindingTemperature;

    @ApiModelProperty(value = "B相顶层油温1")
    private String btopOilTemperatureOne;

    @ApiModelProperty(value = "B相顶层油温2")
    private String btopOilTemperatureTwo;

    @ApiModelProperty(value = "B相铁芯接地电流")
    private String bcoreGroundingCurrent;

    @ApiModelProperty(value = "C相位绕组温度")
    private String cwindingTemperature;

    @ApiModelProperty(value = "C相顶层油温1")
    private String ctopOilTemperatureOne;

    @ApiModelProperty(value = "C相顶层油温2")
    private String ctopOilTemperatureTwo;

    @ApiModelProperty(value = "C相铁芯接地电流")
    private String ccoreGroundingCurrent;

    @ApiModelProperty(value = "三维对应id")
    private String threeId;
}
