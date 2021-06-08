package cn.exrick.xboot.modules.base.query;

import java.time.LocalDateTime;
import cn.exrick.xboot.modules.base.entity.BaseSite;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @desc 站点表 列表分页查询对象
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="BaseSite查询对象", description="站点表查询对象")
public class BaseSiteQuery extends BaseSite{




}
