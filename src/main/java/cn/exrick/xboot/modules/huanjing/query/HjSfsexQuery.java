package cn.exrick.xboot.modules.huanjing.query;

import java.time.LocalDateTime;
import cn.exrick.xboot.modules.huanjing.entity.HjSfsex;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @desc SF6监视表 列表分页查询对象
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="HjSfsex查询对象", description="SF6监视表查询对象")
public class HjSfsexQuery extends HjSfsex{











}
