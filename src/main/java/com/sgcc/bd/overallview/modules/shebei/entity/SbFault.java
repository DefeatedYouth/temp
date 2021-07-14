package com.sgcc.bd.overallview.modules.shebei.entity;

import com.sgcc.bd.overallview.base.StmBaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc 设备履历故障记录表 实体
 * @author chenfeixiang
 * @since 2021-06-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value="SbFault对象", description="设备履历故障记录表")
public class SbFault extends StmBaseEntity {


    private String resourcesId;

    private Long siteId;

    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    private String faultId;

    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    @ApiModelProperty(value = "设备类型")
    private Integer deviceType;

    @ApiModelProperty(value = "故障时间")
    private String breakdownTime;

    @ApiModelProperty(value = "故障类型")
    private Integer type;

    @ApiModelProperty(value = "生产厂家")
    private String manufacturer;

    @ApiModelProperty(value = "故障描述")
    private String description;

    @ApiModelProperty(value = "处理人")
    private String handler;

    @ApiModelProperty(value = "处理时间")
    private String handTime;

    @ApiModelProperty(value = "故障状态")
    private String state;

    @ApiModelProperty(value = "故障性质")
    private String faultNature;

    @ApiModelProperty(value = "故障电流")
    private String faultCurrent;

    @ApiModelProperty(value = "故障相别")
    private String faultPhase;

    @ApiModelProperty(value = "三维对应id")
    private String threeId;

    @ApiModelProperty(value = "故障录波")
    private String faultBo;

    @ApiModelProperty(value = "智能决策")
    private String intelligentDecisionMaking;

    @ApiModelProperty(value = "应急预案")
    private String emergencyPlan;

}
