package cn.exrick.xboot.modules.shebei.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc 断路器状态评价数据数据表 实体
 * @author chenfeixiang
 * @since 2021-06-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value="SbFeed对象", description="断路器状态评价数据数据表")
public class SbFeed extends StmBaseEntity {


    private String resourcesId;

    private Long siteId;

    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    @ApiModelProperty(value = "设备类型")
    private Integer deviceType;

    @ApiModelProperty(value = "电压等级")
    private String voltageLevel;

    @ApiModelProperty(value = "扣分部件")
    private String deductedParts;

    @ApiModelProperty(value = "扣分原因")
    private String deductionReasons;

    @ApiModelProperty(value = "问题描述")
    private String problemDescription;

    @ApiModelProperty(value = "评价日期")
    private Date evaluationDate;

    @ApiModelProperty(value = "设备型号")
    private String equipmentModel;

    @ApiModelProperty(value = "评价结论")
    private String evaluationConclusion;

    @ApiModelProperty(value = "评价扣分")
    private String deductionEvaluationPoints;

    @ApiModelProperty(value = "建议检修内容")
    private String recommendedMaintenanceContents;

    @ApiModelProperty(value = "所属单位")
    private String affiliatedUnits;

    @ApiModelProperty(value = "生产厂家")
    private String manufacturer;

    @ApiModelProperty(value = "投运日期")
    private String commissioningDate;

    @ApiModelProperty(value = "评价类型")
    private String commissioningType;

    @ApiModelProperty(value = "三维对应id")
    private String threeId;
}
