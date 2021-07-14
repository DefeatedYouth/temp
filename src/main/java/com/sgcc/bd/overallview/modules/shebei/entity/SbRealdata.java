package com.sgcc.bd.overallview.modules.shebei.entity;

import com.sgcc.bd.overallview.base.StmBaseEntity;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc 断路器实时状态数据表 实体
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
@ApiModel(value="SbRealdata对象", description="断路器实时状态数据表")
public class SbRealdata extends StmBaseEntity {


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

    @ApiModelProperty(value = "运行挡位")
    private Integer operatingGear;

    @ApiModelProperty(value = "挡位值")
    private String gearPosition;

    @ApiModelProperty(value = "A相位绕组温度")
    private Integer awindingTemperature;

    @ApiModelProperty(value = "A相顶层油温1")
    private Integer atopOilTemperatureOne;

    @ApiModelProperty(value = "A相顶层油温2")
    private Integer atopOilTemperatureTwo;

    @ApiModelProperty(value = "A相铁芯接地电流")
    private Integer acoreGroundingCurrent;

    @ApiModelProperty(value = "B相位绕组温度")
    private Integer bwindingTemperature;

    @ApiModelProperty(value = "B相顶层油温1")
    private Integer btopOilTemperatureOne;

    @ApiModelProperty(value = "B相顶层油温2")
    private Integer btopOilTemperatureTwo;

    @ApiModelProperty(value = "B相铁芯接地电流")
    private Integer bcoreGroundingCurrent;

    @ApiModelProperty(value = "C相位绕组温度")
    private Integer cwindingTemperature;

    @ApiModelProperty(value = "C相顶层油温1")
    private Integer ctopOilTemperatureOne;

    @ApiModelProperty(value = "C相顶层油温2")
    private Integer ctopOilTemperatureTwo;

    @ApiModelProperty(value = "C相铁芯接地电流")
    private Integer ccoreGroundingCurrent;

    @ApiModelProperty(value = "三维对应id")
    private String threeId;

}
