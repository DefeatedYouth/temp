package cn.exrick.xboot.modules.robot.query;

import java.time.LocalDateTime;
import cn.exrick.xboot.modules.robot.entity.RobotAlarm;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @desc 机器人本体告警表 列表分页查询对象
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="RobotAlarm查询对象", description="机器人本体告警表查询对象")
public class RobotAlarmQuery extends RobotAlarm{








}