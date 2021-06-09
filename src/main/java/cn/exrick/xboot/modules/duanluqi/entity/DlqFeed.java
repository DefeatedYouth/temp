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
 * @desc 断路器状态评价数据数据表 实体
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
@ApiModel(value="DlqFeed对象", description="断路器状态评价数据数据表")
public class DlqFeed extends StmBaseEntity {


    private String resourcesId;

    private String siteId;


    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    @ApiModelProperty(value = "设备类型")
    private String deviceType;

    @ApiModelProperty(value = "电压等级")
    private String voltageLevel;

    @ApiModelProperty(value = "扣分部件")
    private String deductedParts;

    @ApiModelProperty(value = "扣分原因")
    private String deductionReasons;

    @ApiModelProperty(value = "问题描述")
    private String problemDescription;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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


}
