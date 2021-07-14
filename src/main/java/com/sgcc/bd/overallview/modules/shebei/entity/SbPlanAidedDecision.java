package com.sgcc.bd.overallview.modules.shebei.entity;

import com.sgcc.bd.overallview.base.StmBaseEntity;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc 计划辅助决策表 实体
 * @author chenfeixiang
 * @since 2021-07-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value="SbPlanAidedDecision对象", description="计划辅助决策表")
public class SbPlanAidedDecision extends StmBaseEntity {


    private Long siteId;

    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    @ApiModelProperty(value = "设备类型")
    private String deviceType;

    @ApiModelProperty(value = "生产厂家")
    private String manufacturer;

    @ApiModelProperty(value = "投运日期")
    private Date commissioningDate;

    @ApiModelProperty(value = "上次检修时间")
    private Date lastOverhaulTime;

    @ApiModelProperty(value = "上次检测时间")
    private Date lastTestTime;

    @ApiModelProperty(value = "缺陷")
    private String defect;

    @ApiModelProperty(value = "隐患")
    private String danger;

    @ApiModelProperty(value = "状态评价结果")
    private String conditionEvaluationResults;

    @ApiModelProperty(value = "带电检测")
    private String liveDetection;


}
