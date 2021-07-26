package com.sgcc.bd.overallview.modules.shebei.entity;

import com.sgcc.bd.overallview.base.StmBaseEntity;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc 设备主动预警表 实体
 * @author chenfeixiang
 * @since 2021-07-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value="SbActiveWarning对象", description="设备主动预警表")
public class SbActiveWarning extends StmBaseEntity {


    private Long siteId;

    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    @ApiModelProperty(value = "设备资源Id")
    private String resourcesId;

    @ApiModelProperty(value = "告警数")
    private String alarmNum;

    @ApiModelProperty(value = "状态")
    private String state;

    @ApiModelProperty(value = "告警量")
    private String alarmQuantity;

    @ApiModelProperty(value = "告警状态量值")
    private String alarmStateValue;

    @ApiModelProperty(value = "预警值")
    private String warningValue;

    @ApiModelProperty(value = "劣化原因")
    private String causesDeterioration;

    @ApiModelProperty(value = "预警类型")
    private String warnType;

    @ApiModelProperty(value = "检修决策")
    private String maintenanceDecision;

    @ApiModelProperty(value = "运维决策")
    private String operationMaintenanceDecision;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;


}
