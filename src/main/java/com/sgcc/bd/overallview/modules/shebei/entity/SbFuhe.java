package com.sgcc.bd.overallview.modules.shebei.entity;

import com.sgcc.bd.overallview.base.StmBaseEntity;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc 断路器负荷数据表 实体 列表默认显示高压测
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

    @ApiModelProperty(value = "设备类型")
    private String deviceType;

    @ApiModelProperty(value = "高压测A相电压")
    private String highAvoltage;

    @ApiModelProperty(value = "高压测B相电压")
    private String highBvoltage;

    @ApiModelProperty(value = "高压测C相电压")
    private String highCvoltage;

    @ApiModelProperty(value = "高压测A相电流")
    private String highAelectric;

    @ApiModelProperty(value = "高压测B相电流")
    private String highBelectric;

    @ApiModelProperty(value = "高压测C相电流")
    private String highCelectric;

    @ApiModelProperty(value = "高压测有功功率")
    private String highActivePower;

    @ApiModelProperty(value = "高压测无功功率")
    private String highReactivePower;

    @ApiModelProperty(value = "中压测A相电压")
    private String middleAvoltage;

    @ApiModelProperty(value = "中压测B相电压")
    private String middleBvoltage;

    @ApiModelProperty(value = "中压测C相电压")
    private String middleCvoltage;

    @ApiModelProperty(value = "中压测A相电流")
    private String middleAelectric;

    @ApiModelProperty(value = "中压测B相电流")
    private String middleBelectric;

    @ApiModelProperty(value = "中压测C相电流")
    private String middleCelectric;

    @ApiModelProperty(value = "中压测有功功率")
    private String middleActivePower;

    @ApiModelProperty(value = "中压测无功功率")
    private String middleReactivePower;

    @ApiModelProperty(value = "低压测A相电压")
    private String lowAvoltage;

    @ApiModelProperty(value = "低压测B相电压")
    private String lowBvoltage;

    @ApiModelProperty(value = "低压测C相电压")
    private String lowCvoltage;

    @ApiModelProperty(value = "低压测A相电流")
    private String lowAelectric;

    @ApiModelProperty(value = "低压测B相电流")
    private String lowBelectric;

    @ApiModelProperty(value = "低压测C相电流")
    private String lowCelectric;

    @ApiModelProperty(value = "低压测有功功率")
    private String lowActivePower;

    @ApiModelProperty(value = "低压测无功功率")
    private String lowReactivePower;

    @ApiModelProperty(value = "负载率")
    private String loadFactor;

    @ApiModelProperty(value = "三维对应id")
    private String threeId;

    @ApiModelProperty(value = "是否重过载")
    private String  isWeight;

    @ApiModelProperty(value = "本月累计重载持续时间")
    private String accumulatedTime;
}
