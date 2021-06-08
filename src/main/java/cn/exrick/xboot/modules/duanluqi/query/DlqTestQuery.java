package cn.exrick.xboot.modules.duanluqi.query;

import java.time.LocalDateTime;
import cn.exrick.xboot.modules.duanluqi.entity.DlqTest;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @desc 断路器履历实验信息表 列表分页查询对象
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="DlqTest查询对象", description="断路器履历实验信息表查询对象")
public class DlqTestQuery extends DlqTest{

















}
