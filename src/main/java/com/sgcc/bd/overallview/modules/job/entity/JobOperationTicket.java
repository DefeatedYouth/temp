package com.sgcc.bd.overallview.modules.job.entity;

import com.sgcc.bd.overallview.base.StmBaseEntity;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc 操作票表 实体
 * @author chenfeixiang
 * @since 2021-07-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value="JobOperationTicket对象", description="操作票表")
public class JobOperationTicket extends StmBaseEntity {


    private Long siteId;

    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    @ApiModelProperty(value = "城市")
    private String city;

    @ApiModelProperty(value = "运维单位")
    private String operationUnit;

    @ApiModelProperty(value = "工作班组")
    private String workingTeam;

    @ApiModelProperty(value = "操作任务")
    private String operationTask;

    @ApiModelProperty(value = "票状态")
    private String ticketStatus;

    @ApiModelProperty(value = "票号")
    private String number;

    @ApiModelProperty(value = "制票时间")
    private Date ticketMakingTime;

    @ApiModelProperty(value = "操作开始时间")
    private Date operationStartTime;

    @ApiModelProperty(value = "操作结束时间")
    private Date operationEndTime;

    @ApiModelProperty(value = "操作步骤")
    private String operationSteps;


}
