package com.sgcc.bd.overallview.modules.robot.entity;

import com.sgcc.bd.overallview.base.StmBaseEntity;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc 机器人本体告警表 实体
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
@ApiModel(value="RobotAlarm对象", description="机器人本体告警表")
public class RobotAlarm extends StmBaseEntity {


    @ApiModelProperty(value = "站点Id")
    private Long siteId;

    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    @ApiModelProperty(value = "机器人Id")
    private String robotId;

    @ApiModelProperty(value = "机器人名称")
    private String robotName;

    @ApiModelProperty(value = "发现时间")
    private Date findTime;

    @ApiModelProperty(value = "装置名称")
    private String deviceName;

    @ApiModelProperty(value = "告警类型")
    private String alarmType;

    @ApiModelProperty(value = "告警描述")
    private String alarmDesc;

    @ApiModelProperty(value = "状态")
    private String alarmState;

    @ApiModelProperty(value = "告警等级")
    private Integer alarmLevel;

    @ApiModelProperty(value = "数据源id")
    private String resourcesId;

    @ApiModelProperty(value = "三维对应id")
    private String threeId;
}
