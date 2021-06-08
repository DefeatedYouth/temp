package cn.exrick.xboot.modules.duanluqi.query;

import java.time.LocalDateTime;
import cn.exrick.xboot.modules.duanluqi.entity.DlqRealdata;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @desc 断路器实时状态数据表 列表分页查询对象
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="DlqRealdata查询对象", description="断路器实时状态数据表查询对象")
public class DlqRealdataQuery extends DlqRealdata{






}
