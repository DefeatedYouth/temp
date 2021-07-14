package com.sgcc.bd.overallview.modules.anxiaofang.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/6/22 14:56
 * @File: AccessControlInformationDTO
 */
@Data
public class AccessControlInformationDTO {
    @ApiModelProperty(value = "总数")
    private Integer totalNum;

    @ApiModelProperty(value = "门禁开启状态总数")
    private Integer openFlag;

    @ApiModelProperty(value = "控制器故障总数")
    private Integer controllerFailure;

    @ApiModelProperty(value = "通信异常")
    private Integer communicationNum;

    @ApiModelProperty(value = "报警数量")
    private Integer alarmNum;
}
