package com.sgcc.bd.overallview.modules.robot.entity;

import com.sgcc.bd.overallview.base.StmBaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @desc 机器人巡视报文表 实体
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
@ApiModel(value="RobotInspMessage对象", description="机器人巡视报文表")
public class RobotInspMessage extends StmBaseEntity {


    @ApiModelProperty(value = "站点Id")
    private Long siteId;

    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    @ApiModelProperty(value = "机器人Id")
    private String robotId;

    @ApiModelProperty(value = "机器人名称")
    private String robotName;

    @ApiModelProperty(value = "巡视任务名称")
    private String inspName;

    @ApiModelProperty(value = "监测时间")
    private Date inspTime;

    @ApiModelProperty(value = "巡视点位")
    private String inspPoints;

    @ApiModelProperty(value = "识别类型")
    private String inspType;

    @ApiModelProperty(value = "巡视值")
    private String inspValue;

    @ApiModelProperty(value = "文件")
    private String inspFile;

    @ApiModelProperty(value = "结论")
    private String inspResult;

    @ApiModelProperty(value = "告警等级")
    private String alarmLevel;

    @ApiModelProperty(value = "数据源id")
    private String resourcesId;

    @ApiModelProperty(value = "三维对应id")
    private String threeId;

    private String equipmentNameNumber;
}
