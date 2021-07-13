package cn.exrick.xboot.modules.overview.dto;

import cn.exrick.xboot.modules.base.dto.DeviceCountDTO;
import cn.exrick.xboot.modules.shebei.entity.SbToolMonitoring;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.domain.PageRequest;

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
