package cn.exrick.xboot.modules.job.query;

import java.time.LocalDateTime;
import cn.exrick.xboot.modules.job.entity.JobMaintenanceTasks;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @desc  列表分页查询对象
 * @author chenfeixiang
 * @since 2021-07-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="JobMaintenanceTasks查询对象", description="查询对象")
public class JobMaintenanceTasksQuery extends JobMaintenanceTasks{










}
