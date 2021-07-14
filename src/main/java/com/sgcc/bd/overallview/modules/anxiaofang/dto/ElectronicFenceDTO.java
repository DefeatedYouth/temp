package com.sgcc.bd.overallview.modules.anxiaofang.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/6/22 14:25
 * @File: ElectronicFenceDTO
 */
@Data
public class ElectronicFenceDTO {
    @ApiModelProperty(value = "总数")
    private Integer totalNum;

    @ApiModelProperty(value = "布防状态总数")
    private Integer deploymentNum;

    @ApiModelProperty(value = "撤防状态总数")
    private Integer withdrawalNum;

    @ApiModelProperty(value = "电源异常")
    private Integer abnormalNum;

    @ApiModelProperty(value = "通信异常")
    private Integer communicationNum;

    @ApiModelProperty(value = "报警数量")
    private Integer alarmNum;
}
