package com.sgcc.bd.overallview.modules.overview.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/7/12 15:35
 * @File: SparePartsMonitoringDTO
 */
@Data
public class SparePartsMonitoringDTO {

    @ApiModelProperty(value = "断路器")
    private Integer breakerNum=0;
}
