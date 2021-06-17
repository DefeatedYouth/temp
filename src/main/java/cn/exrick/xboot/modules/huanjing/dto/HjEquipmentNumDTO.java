package cn.exrick.xboot.modules.huanjing.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/6/17 14:18
 * @File: HjEquipmentNumDTO
 */
@Data
public class HjEquipmentNumDTO {
    @ApiModelProperty(value = "总数")
    private Integer totalNum;
    @ApiModelProperty(value = "开启数量")
    private Integer openNum;
    @ApiModelProperty(value = "关闭数量")
    private Integer downNum;
    @ApiModelProperty(value = "通信异常")
    private Integer abnormalCommunicationNum;
    @ApiModelProperty(value = "告警数量")
    private Integer alarmNum;
    @ApiModelProperty(value = "sf6最大浓度")
    private String sfSixMax;
    @ApiModelProperty(value = "CO2最大浓度")
    private String cotwoMax;
    @ApiModelProperty(value = "水位最大高度")
    private String waterLevelMax;
}
