package cn.exrick.xboot.modules.base.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/6/26 15:37
 * @File: AnFireDTO
 */
@Data
public class AnFireDTO {
    @ApiModelProperty(value = "消防告警数量")
    private Integer fireAlarmsNum;

    @ApiModelProperty(value = "装置异常数量")
    private Integer deviceAbnormalNum;

    @ApiModelProperty(value = "消防火灾数量")
    private Integer fireFireNum;

    @ApiModelProperty(value = "图像识别 装置异常数量")
    private Integer imageDeviceAbnormalNum;

    @ApiModelProperty(value = "图像识别 摄像头数量")
    private Integer imageCameraNum;

    @ApiModelProperty(value = "防区告警数量")
    private Integer zoneAlarmNum;

    @ApiModelProperty(value = "装置异常数量")
    private Integer zoneDeviceAbnormalNum;

    @ApiModelProperty(value = "电子围栏数量")
    private Integer zoneElectricFenceNum;

    @ApiModelProperty(value = "门禁告警数量")
    private Integer accessControlAlarmNum;

    @ApiModelProperty(value = "装置异常数量")
    private Integer accessDeviceAbnormalNum;

    @ApiModelProperty(value = "门禁数量")
    private Integer accessNum;
}
