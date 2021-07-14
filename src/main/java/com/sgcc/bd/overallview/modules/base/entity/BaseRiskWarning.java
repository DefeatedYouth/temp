package com.sgcc.bd.overallview.modules.base.entity;

import com.sgcc.bd.overallview.base.StmBaseEntity;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc 交直流系统监视表 实体
 * @author chenfeixiang
 * @since 2021-06-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value="BaseRiskWarning对象", description="交直流系统监视表")
public class BaseRiskWarning extends StmBaseEntity {


    private String resourcesId;

    private Long siteId;

    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    @ApiModelProperty(value = "编号")
    private Long number;

    @ApiModelProperty(value = "主题")
    private String theme;

    @ApiModelProperty(value = "单位")
    private String company;

    @ApiModelProperty(value = "日期")
    private Date datee;

    @ApiModelProperty(value = "风险等级")
    private String riskLevel;

    @ApiModelProperty(value = "签收部门")
    private String receivingDepartment;

    @ApiModelProperty(value = "停电设备/事由")
    private String blackoutEquipmentCause;

    @ApiModelProperty(value = "工期/时段")
    private String durationPeriod;

    @ApiModelProperty(value = "运行安全风险分析")
    private String operationSafetyRiskAnalysis;

    @ApiModelProperty(value = "风险管控措施要求")
    private String requirementsRiskControlMeasures;

    @ApiModelProperty(value = "附件地址")
    private String enclosure;


}
