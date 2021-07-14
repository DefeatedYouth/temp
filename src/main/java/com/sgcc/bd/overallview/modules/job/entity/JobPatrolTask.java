package com.sgcc.bd.overallview.modules.job.entity;

import com.sgcc.bd.overallview.base.StmBaseEntity;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc 巡视任务表 实体
 * @author chenfeixiang
 * @since 2021-07-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value="JobPatrolTask对象", description="巡视任务表")
public class JobPatrolTask extends StmBaseEntity {


    private Long siteId;

    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    @ApiModelProperty(value = "所属地市公司")
    private String cityOrgname;

    @ApiModelProperty(value = "运维单位")
    private String workOrgname;

    @ApiModelProperty(value = "工作班组")
    private String workBanzhu;

    @ApiModelProperty(value = "重要等级")
    private String importantLevel;

    @ApiModelProperty(value = "巡视等级")
    private String inspectionType;

    @ApiModelProperty(value = "计划巡视到期时间")
    private Date scheduledTourDueTime;

    @ApiModelProperty(value = "巡视开始时间")
    private Date inspectionStartTime;

    @ApiModelProperty(value = "巡视结束时间")
    private Date inspectionEndTime;

    @ApiModelProperty(value = "巡视超期时间")
    private Date inspectionOverTime;

    @ApiModelProperty(value = "计划状态")
    private String planState;

    @ApiModelProperty(value = "详情")
    private String detail;


}
