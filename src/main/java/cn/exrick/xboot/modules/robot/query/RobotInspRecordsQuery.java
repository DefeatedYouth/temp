package cn.exrick.xboot.modules.robot.query;

import java.time.LocalDateTime;
import java.util.Date;

import cn.exrick.xboot.modules.robot.entity.RobotInspRecords;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @desc 机器人巡视记录表 列表分页查询对象
 * @author chenfeixiang
 * @since 2021-06-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="RobotInspRecords查询对象", description="机器人巡视记录表查询对象")
public class RobotInspRecordsQuery extends RobotInspRecords{

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "结束时间")
    private Date endTime;

}
