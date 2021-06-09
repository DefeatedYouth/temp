package cn.exrick.xboot.modules.duanluqi.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @desc 断路器履历检修信息表 实体
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
@ApiModel(value="DlqOverhaul对象", description="断路器履历检修信息表")
public class DlqOverhaul extends StmBaseEntity {


    private String resourcesId;

    private String siteId;

    @ApiModelProperty(value = "是否外接")
    private Integer externalFlag;

    @ApiModelProperty(value = "工作票号")
    private String workTicketNumber;

    @ApiModelProperty(value = "工作班组")
    private String workingTeam;

    @ApiModelProperty(value = "状态检修类型")
    private String conditionBasedMaintenanceType;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "工作日期")
    private Date workDate;

    @ApiModelProperty(value = "工作负责人")
    private String workCharge;

    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    @ApiModelProperty(value = "专业性质")
    private String professionalNature;

    @ApiModelProperty(value = "间隔名称")
    private String intervalName;

    @ApiModelProperty(value = "结论")
    private String conclusion;

    @ApiModelProperty(value = "工作人员")
    private String workMan;

    @ApiModelProperty(value = "工作内容")
    private String workContent;

    @ApiModelProperty(value = "调度情况")
    private String dispatchSituation;

    @ApiModelProperty(value = "遗留问题		")
    private String remainingProblems;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "缺陷等级")
    private String defectLevel;
}
