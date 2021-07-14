package com.sgcc.bd.overallview.modules.job.entity;

import com.sgcc.bd.overallview.base.StmBaseEntity;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

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


    private Long siteId;


    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    @ApiModelProperty(value = "计划类型")
    private String planType;

    @ApiModelProperty(value = "是否为综合计划")
    private String isComplan;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "计划开始时间")
    private Date beginTime;

    @ApiModelProperty(value = "状态")
    private String jobState;

    @ApiModelProperty(value = "负责人")
    private String personCharge;

    @ApiModelProperty(value = "计划结束时间")
    private String endTime;

    @ApiModelProperty(value = "电压等级")
    private String voltageLevel;

    @ApiModelProperty(value = "工作内容")
    private String jobContent;

    @ApiModelProperty(value = "是否停电")
    private String powerFailure;

    @ApiModelProperty(value = "是否超期")
    private Integer overFlag;

    @ApiModelProperty(value = "0检修1运维2带电检测")
    private Integer state;
}
