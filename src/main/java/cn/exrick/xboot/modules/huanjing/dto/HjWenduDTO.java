package cn.exrick.xboot.modules.huanjing.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/6/17 10:30
 * @File: HjWenduDTO
 */
@Data
public class HjWenduDTO {
    @ApiModelProperty(value = "温度（湿度）监测总数")
    private Integer totalNum;
    @ApiModelProperty(value = "最高（湿度）温度")
    private String maximumTemperature;

    @ApiModelProperty(value = "通信异常数量")
    private Integer abnormalCommunication;
    @ApiModelProperty(value = "告警数量")
    private Integer alarmNum;
}
