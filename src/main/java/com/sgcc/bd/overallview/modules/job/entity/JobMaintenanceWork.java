package com.sgcc.bd.overallview.modules.job.entity;

import com.sgcc.bd.overallview.base.StmBaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @desc  实体
 * @author chenfeixiang
 * @since 2021-07-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value="JobMaintenanceWork对象", description="")
public class JobMaintenanceWork extends StmBaseEntity {


    private Long siteId;

    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    @ApiModelProperty(value = "'运维班'")
    private String deparentName;


    @ApiModelProperty(value = "维护项目")
    private String maintenanceProject;

    @ApiModelProperty(value = "'作业人员'")
    private String operators;

    @ApiModelProperty(value = "'上次维护时间'")
    private Date lastMaintenanceTime;

    @ApiModelProperty(value = "'维护次数")
    private Integer maintenanceTimes;
}
