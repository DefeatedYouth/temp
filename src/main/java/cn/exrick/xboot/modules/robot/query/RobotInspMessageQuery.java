package cn.exrick.xboot.modules.robot.query;

import java.time.LocalDateTime;
import cn.exrick.xboot.modules.robot.entity.RobotInspMessage;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @desc 机器人巡视报文表 列表分页查询对象
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="RobotInspMessage查询对象", description="机器人巡视报文表查询对象")
public class RobotInspMessageQuery extends RobotInspMessage{










}
