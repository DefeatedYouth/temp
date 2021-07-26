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
    private Integer totalNum=0;

    @ApiModelProperty(value = "健康")
    private Integer healthNum=0;

    @ApiModelProperty(value = "亚健康")
    private Integer subhealthNum=0;

    @ApiModelProperty(value = "注意")
    private Integer noteNum=0;

    @ApiModelProperty(value = "异常")
    private Integer abnormalNum=0;

    @ApiModelProperty(value = "严重")
    private Integer seriousNum=0;

}
