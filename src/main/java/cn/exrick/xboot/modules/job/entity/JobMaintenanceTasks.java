package cn.exrick.xboot.modules.job.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

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
@ApiModel(value="JobMaintenanceTasks对象", description="")
public class JobMaintenanceTasks extends StmBaseEntity {


    private Long siteId;

    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    @ApiModelProperty(value = "城市")
    private String city;

    @ApiModelProperty(value = "运维单位")
    private String operationUnit;

    @ApiModelProperty(value = "工作班组")
    private String workingTeam;

    @ApiModelProperty(value = "维护项目")
    private String maintenanceProject;

    @ApiModelProperty(value = "维护细项")
    private String maintenanceDetails;

    @ApiModelProperty(value = "维护周期")
    private Date maintenanceDate;

    @ApiModelProperty(value = "维护周期")
    private String maintenanceCycle;


}
