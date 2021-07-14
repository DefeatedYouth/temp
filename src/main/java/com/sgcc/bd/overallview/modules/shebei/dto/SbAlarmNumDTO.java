package com.sgcc.bd.overallview.modules.shebei.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/6/16 13:04
 * @File: SbAlarmNumDTO
 */
@Data
public class SbAlarmNumDTO {
    @ApiModelProperty(value = "事故告警数量")
    private Integer accidentAlarmNum;
    @ApiModelProperty(value = "事故未处理数量")
    private Integer unhandledNum;
}
