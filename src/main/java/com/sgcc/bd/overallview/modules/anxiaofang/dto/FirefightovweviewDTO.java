package com.sgcc.bd.overallview.modules.anxiaofang.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/6/18 10:14
 * @File: firefightovweviewDTO
 */
@Data
public class FirefightovweviewDTO {
    @ApiModelProperty(value = "消防设施总数")
    private Integer totalFireFightingNum=0;
    @ApiModelProperty(value = "消防火灾总报警")
    private String  fireAlarmNum="0";
    @ApiModelProperty(value = "变压器消防火灾告警")
    private Integer transformerFireAlarm=0;
    @ApiModelProperty(value = "变压器灭火装置异常")
    private Integer transformerFireExtinguishingNum=0;
    @ApiModelProperty(value = "烟感探测器报警")
    private Integer smokeDetectorAlarm=0;
    @ApiModelProperty(value = "火灾探测器报警")
    private Integer fireDetectorAlarm=0;
    @ApiModelProperty(value = "消防装置故障")
    private Integer fireProtectionDeviceFailure=0;
}
