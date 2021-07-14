package com.sgcc.bd.overallview.modules.overview.dto;

import com.sgcc.bd.overallview.modules.base.dto.DeviceCountDTO;
import com.sgcc.bd.overallview.modules.shebei.entity.SbToolMonitoring;
import lombok.Data;

import java.util.List;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/7/12 16:59
 * @File: ToolMonitoringDTO
 */
@Data
public class ToolMonitoringDTO {

  //  @ApiModelProperty(value = "断路器")
    List<DeviceCountDTO> deviceCountDTOS;

    List<SbToolMonitoring> sbToolMonitorings ;
}
