package cn.exrick.xboot.modules.job.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc 检修作业表 实体
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value="JobRepair对象", description="检修作业表")
public class JobRepair extends StmBaseEntity {


    private String siteId;

    @ApiModelProperty(value = "计划类型")
    private String planType;

    @ApiModelProperty(value = "是否为综合计划")
    private String isComplan;

    @ApiModelProperty(value = "计划编制时间")
    private Date planTime;

    @ApiModelProperty(value = "所属地市公司")
    private String cityOrgname;

    @ApiModelProperty(value = "运维单位")
    private String workOrgname;

    @ApiModelProperty(value = "工作班组")
    private String workBanzhu;

    @ApiModelProperty(value = "票名称")
    private String jobName;

    @ApiModelProperty(value = "任务类型")
    private String jobType;

    @ApiModelProperty(value = "计划开始时间")
    private Date beginTime;

    @ApiModelProperty(value = "状态")
    private String jobState;


}
