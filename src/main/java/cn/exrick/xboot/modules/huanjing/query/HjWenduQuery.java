package cn.exrick.xboot.modules.huanjing.query;

import java.time.LocalDateTime;
import cn.exrick.xboot.modules.huanjing.entity.HjWendu;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @desc 温度监视表 列表分页查询对象
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="HjWendu查询对象", description="温度监视表查询对象")
public class HjWenduQuery extends HjWendu{








}
