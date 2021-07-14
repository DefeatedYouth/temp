package com.sgcc.bd.overallview.modules.base.entity;

import com.sgcc.bd.overallview.base.StmBaseEntity;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc 巡视风险表 实体
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
@ApiModel(value="BaseInspectionRisk对象", description="巡视风险表")
public class BaseInspectionRisk extends StmBaseEntity {


    private Long siteId;

    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    @ApiModelProperty(value = "城市信息")
    private String city;

    @ApiModelProperty(value = "巡视类型")
    private String inspectionType;

    @ApiModelProperty(value = "计划巡视到期时间")
    private Date endTime;

    @ApiModelProperty(value = "计划状态")
    private String planState;

    @ApiModelProperty(value = "隐患细项")
    private String hiddenDangerItems;

    @ApiModelProperty(value = "预控措施")
    private String preControlMeasures;


}
