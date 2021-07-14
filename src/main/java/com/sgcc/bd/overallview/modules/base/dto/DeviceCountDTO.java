package com.sgcc.bd.overallview.modules.base.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author chenfeixiang6@163.com
 * @date 2021/7/5
 * @desc
 */
@Data
public class DeviceCountDTO {

    @ApiModelProperty(value = "设备名称")
    private String equipmentName;
    @ApiModelProperty(value = "数量")
    private Long num;

}
