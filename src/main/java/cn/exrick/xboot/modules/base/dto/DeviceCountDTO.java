package cn.exrick.xboot.modules.base.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/6/26 13:55
 * @File: DeviceCountDTO
 */
@Data
public class DeviceCountDTO {

    @ApiModelProperty(value = "变压器")
    private Integer transformerNum;
    @ApiModelProperty(value = "电抗器")
    private Integer reactorNum;
    @ApiModelProperty(value = "断路器")
    private Integer breakerNum;
    @ApiModelProperty(value = "电流互感器")
    private Integer currentTransformerNum;
    @ApiModelProperty(value = "电压互感器")
    private Integer voltageTransformerNum;
    @ApiModelProperty(value = "隔离开关")
    private Integer  isolatingSwitchNum;
    @ApiModelProperty(value = "避雷器")
    private Integer  lightningArresterNum;
    @ApiModelProperty(value = "组合电器")
    private Integer  combinationAppliancesNum;

}
