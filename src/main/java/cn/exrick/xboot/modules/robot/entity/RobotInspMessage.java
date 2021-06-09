package cn.exrick.xboot.modules.robot.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @desc 机器人巡视报文表 实体
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
@ApiModel(value="RobotInspMessage对象", description="机器人巡视报文表")
public class RobotInspMessage extends StmBaseEntity {


    @ApiModelProperty(value = "站点Id")
    private String siteId;


    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    @ApiModelProperty(value = "机器人Id")
    private String robotId;

    @ApiModelProperty(value = "巡视任务名称")
    private String inspName;

    @ApiModelProperty(value = "监测时间")
    private String inspTime;

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

}
