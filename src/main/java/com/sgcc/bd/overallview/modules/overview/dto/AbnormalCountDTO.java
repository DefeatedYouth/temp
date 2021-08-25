package com.sgcc.bd.overallview.modules.overview.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/7/12 14:09
 * @File: AbnormalCountDTO
 */
@Data
public class AbnormalCountDTO {

    @ApiModelProperty(value = "健康趋势异常")
    private Integer abnormalHealthNum=0;

    @ApiModelProperty(value = "寿命下降异常")
    private Integer abnormalDecreaseNum=0;

    @ApiModelProperty(value = "实验异常")
    private Integer experimentAbnormalNum=0;

    @ApiModelProperty(value = "带电检测异常")
    private Integer chargeDetectionNum=0;

    @ApiModelProperty(value = "状态评价异常")
    private Integer abnormalStatusNum=0;

    @ApiModelProperty(value = "状态评价严重")
    private Integer seriousStatusNum=0;
}
