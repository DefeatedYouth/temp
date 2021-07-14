package com.sgcc.bd.overallview.modules.overview.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/7/12 14:09
 * @File: AbnormalCountDTO
 */
@Data
public class AbnormalCountDTO {

    @ApiModelProperty(value = "健康趋势异常")
    private Integer abnormalHealthNum;

    @ApiModelProperty(value = "寿命下降异常")
    private Integer abnormalDecreaseNum;

    @ApiModelProperty(value = "实验异常")
    private Integer experimentAbnormalNum;

    @ApiModelProperty(value = "带电检测异常")
    private Integer chargeDetectionNum;

    @ApiModelProperty(value = "状态评价异常")
    private Integer abnormalStatusNum;

    @ApiModelProperty(value = "状态评价严重")
    private Integer seriousStatusNum;
}
