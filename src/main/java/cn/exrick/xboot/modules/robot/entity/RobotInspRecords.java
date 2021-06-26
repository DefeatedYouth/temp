package cn.exrick.xboot.modules.robot.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @desc 机器人巡视记录表 实体
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
@ApiModel(value="RobotInspRecords对象", description="机器人巡视记录表")
public class RobotInspRecords extends StmBaseEntity {


    @ApiModelProperty(value = "站点Id")
    private Long siteId;

    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    @ApiModelProperty(value = "机器人Id")
    private Integer robotId;

    @ApiModelProperty(value = "机器人名称")
    private String robotName;

    @ApiModelProperty(value = "巡视任务名称")
    private String inspName;

    @ApiModelProperty(value = "监测时间")
    private Date inspTime;

    @ApiModelProperty(value = "文件")
    private String inspFile;

    @ApiModelProperty(value = "'任务状态'")
    private Integer taskType;

    @ApiModelProperty(value = "巡视点位数量")
    private Integer pointNum;

    @ApiModelProperty(value = "摄像机总数")
    private Integer cameraNum;

    @ApiModelProperty(value = "枪机数量")
    private Integer gunNum;

    @ApiModelProperty(value = "球机数量")
    private Integer speedDomeNum;
    @ApiModelProperty(value = "云台数量")
    private Integer yuntaiNum;
    @ApiModelProperty(value = "红外")
    private Integer redNum;
    @ApiModelProperty(value = "可见光")
    private Integer lightNum;

    @ApiModelProperty(value = "红外和可见光")
    private Integer redLightNum;
    @ApiModelProperty(value = "未识别")
    private Integer unrecognizedNum;
    @ApiModelProperty(value = "一般")
    private Integer commonlyNum;
    @ApiModelProperty(value = "严重")
    private Integer seriousNum;
    @ApiModelProperty(value = "危急")
    private Integer criticalNum;

    @ApiModelProperty(value = "比率")
    private Integer ratio;
    @ApiModelProperty(value = "机器人id集合")
    private Integer robot;
}
