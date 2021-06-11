package cn.exrick.xboot.modules.robot.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc 机器人实时数据表 实体
 * @author chenfeixiang
 * @since 2021-06-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value="RobotRealdata对象", description="机器人实时数据表")
public class RobotRealdata extends StmBaseEntity {


    @ApiModelProperty(value = "站点Id")
    private Long siteId;

    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    @ApiModelProperty(value = "机器人Id")
    private String robotId;

    @ApiModelProperty(value = "机器人名称")
    private String robotName;

    @ApiModelProperty(value = "电池电量")
    private String batteryLevel;

    @ApiModelProperty(value = "通讯状态")
    private String linkState;

    @ApiModelProperty(value = "驱动状态")
    private String deviceState;

    @ApiModelProperty(value = "运行状态")
    private String runState;

    @ApiModelProperty(value = "控制模式")
    private String operateModel;

    @ApiModelProperty(value = "轮转状态")
    private String rotationState;

    @ApiModelProperty(value = "运行速度")
    private String speedValue;

    @ApiModelProperty(value = "行驶里程")
    private String mileageValue;


}
