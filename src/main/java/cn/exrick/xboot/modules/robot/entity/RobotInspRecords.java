package cn.exrick.xboot.modules.robot.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

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
    private String siteId;

    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    @ApiModelProperty(value = "机器人Id")
    private Integer robotId;

    @ApiModelProperty(value = "机器人Id")
    private String robotName;

    @ApiModelProperty(value = "巡视任务名称")
    private String inspName;

    @ApiModelProperty(value = "监测时间")
    private String inspTime;

    @ApiModelProperty(value = "文件")
    private String inspFile;


}
