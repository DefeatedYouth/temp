package com.sgcc.bd.overallview.modules.overview.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;
import org.aspectj.lang.annotation.DeclareAnnotation;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/7/12 16:23
 * @File: EquipmentHealthDTO
 */
@Data
public class EquipmentHealthDTO {

    @ApiModelProperty(value = "设备总数")
    private Integer totalNum;

    @ApiModelProperty(value = "健康")
    private Integer healthNum;

    @ApiModelProperty(value = "亚健康")
    private Integer subhealthNum;

    @ApiModelProperty(value = "注意")
    private Integer noteNum;

    @ApiModelProperty(value = "异常")
    private Integer abnormalNum;

    @ApiModelProperty(value = "严重")
    private Integer seriousNum;

}
