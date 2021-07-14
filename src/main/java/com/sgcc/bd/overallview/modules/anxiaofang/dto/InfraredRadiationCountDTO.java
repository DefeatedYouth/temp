package com.sgcc.bd.overallview.modules.anxiaofang.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/6/22 11:27
 * @File: InfraredRadiationCountDTO
 */
@Data
public class InfraredRadiationCountDTO {

    @ApiModelProperty(value = "总数")
    private Integer totalNum;

    @ApiModelProperty(value = "装置故障")
    private Integer deviceFailureNum;

    @ApiModelProperty(value = "通信异常")
    private Integer abnormalPowerSupplyNum;

    @ApiModelProperty(value = "报警数量")
    private Integer alarmNum;
}
