package cn.exrick.xboot.modules.job.query;

import java.time.LocalDateTime;
import cn.exrick.xboot.modules.job.entity.JobTicket;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @desc 工作票表 列表分页查询对象
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="JobTicket查询对象", description="工作票表查询对象")
public class JobTicketQuery extends JobTicket{












}
