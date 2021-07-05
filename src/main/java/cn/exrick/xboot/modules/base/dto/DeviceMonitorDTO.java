package cn.exrick.xboot.modules.base.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/6/26 14:46
 * @File: DeviceMonitorDTO
 */
@Data
public class DeviceMonitorDTO {
    @ApiModelProperty(value = "一般缺陷")
    private Integer generalDefectsNum;

    @ApiModelProperty(value = "严重缺陷")
    private Integer seriousFlawsNum;

    @ApiModelProperty(value = "危急缺陷")
    private Integer criticalDefectNum;

    @ApiModelProperty(value = "设备隐患")
    private Integer hiddenNum;

    @ApiModelProperty(value = "监控告警")
    private Integer monitoringAlarmNum;

    @ApiModelProperty(value = "设备故障")
    private Integer failureNum;

//    @ApiModelProperty(value = "名称(一般缺陷,严重缺陷,危急缺陷,设备隐患,监控告警,设备故障)")
//    private String describe;
//
//    @ApiModelProperty(value = "数量")
//    private Integer num;
//
//    @ApiModelProperty(value = "状态")
//    private String code = "未处理";
}
