package cn.exrick.xboot.modules.bianyaqi.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @desc 变压器缺陷信息账表 实体
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
@ApiModel(value="ByqDefect对象", description="变压器缺陷信息账表")
public class ByqDefect extends StmBaseEntity {


    private String resourcesId;

    private String siteId;


    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    @ApiModelProperty(value = "缺陷编号")
    private String defectNumber;

    @ApiModelProperty(value = "缺陷设备")
    private String defectDevice;

    @ApiModelProperty(value = "设备双重命名")
    private String devicesDualNaming;

    @ApiModelProperty(value = "战线类型")
    private String typeFront;

    @ApiModelProperty(value = "电站/路线")
    private String route;

    @ApiModelProperty(value = "电压等级")
    private String voltageLevel;

    @ApiModelProperty(value = "设备类型")
    private String deviceType;

    @ApiModelProperty(value = "设备种类")
    private String equipmentType;

    @ApiModelProperty(value = "设备型号")
    private String deviceModel;

    @ApiModelProperty(value = "部件")
    private String parts;

    @ApiModelProperty(value = "部件种类")
    private String componentType;

    @ApiModelProperty(value = "生产厂家")
    private String manufacturer;

    @ApiModelProperty(value = "投运日期")
    private String commissioningDate;

    @ApiModelProperty(value = "典型特征")
    private String typicalFeatures;

    @ApiModelProperty(value = "汇报调度情况")
    private String reportDispatchingSituationLocation;

    @ApiModelProperty(value = "汇报监控情况")
    private String reportMonitoringLocation;

    @ApiModelProperty(value = "发送方式")
    private String sendType;

    @ApiModelProperty(value = "发现人")
    private String sendMan;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "发现日期")
    private Date sendDate;

    @ApiModelProperty(value = "发现班组")
    private String discoveryTeam;

    @ApiModelProperty(value = "发现人单位		")
    private String discovererUnit;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "登记时间")
    private Date registrationTime;

    @ApiModelProperty(value = "登记人")
    private String registrationMan;

    @ApiModelProperty(value = "缺陷部位")
    private String defectLocation;

    @ApiModelProperty(value = "缺陷描述")
    private String defectDescription;

    @ApiModelProperty(value = "缺陷性质")
    private String defectsNature;

    @ApiModelProperty(value = "分类依据		")
    private String classificationBasis;

    @ApiModelProperty(value = "缺陷内容		")
    private String defectContent;

    @ApiModelProperty(value = "状态量")
    private String stateQuantity;

    @ApiModelProperty(value = "扣分值")
    private String deductionValue;

    @ApiModelProperty(value = "状态值")
    private String stateValue;

    @ApiModelProperty(value = "建议检修类别")
    private String recommendedMaintenanceCategory;

    @ApiModelProperty(value = "建议检修时间")
    private String recommendedMaintenanceTime;

    @ApiModelProperty(value = "建议检修内容")
    private String recommendedMaintenanceContents;

    @ApiModelProperty(value = "拟采取检修内容")
    private String adoptedMaintenanceContents;

    @ApiModelProperty(value = "	验收人")
    private String acceptancePerson;

    @ApiModelProperty(value = "验收班组")
    private String acceptanceTeam;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "验收时间		")
    private Date acceptanceTime;

    @ApiModelProperty(value = "汇报调度情况")
    private String reportDispatchingSituationAcceptance;

    @ApiModelProperty(value = "汇报监控情况		")
    private String reportMonitoringAcceptance;

    @ApiModelProperty(value = "验收意见")
    private String acceptanceComments;

    @ApiModelProperty(value = "备注")
    private String remarks;


    @ApiModelProperty(value = "缺陷等级")
    private String defectLevel;
}
