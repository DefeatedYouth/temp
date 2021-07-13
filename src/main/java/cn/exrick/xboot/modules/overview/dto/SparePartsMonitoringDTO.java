package cn.exrick.xboot.modules.overview.dto;

import cn.exrick.xboot.modules.base.entity.BaseMeteorologicalWarning;
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
    private Integer breakerNum;
}
