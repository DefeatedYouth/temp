package cn.exrick.xboot.modules.base.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/6/26 17:03
 * @File: InspectionPlanDTO
 */
@Data
public class InspectionPlanDTO {
    @ApiModelProperty(value = "计划总数")
    private Integer planTotal;

    @ApiModelProperty(value = "经行中数量")
    private Integer lineNum;

    @ApiModelProperty(value = "未开始数量")
    private Integer notStartedNum;

    @ApiModelProperty(value = "已完成数量")
    private Integer completedNum;

}
