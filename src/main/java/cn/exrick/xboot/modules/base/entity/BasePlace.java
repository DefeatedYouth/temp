package cn.exrick.xboot.modules.base.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc  实体
 * @author chenfeixiang
 * @since 2021-06-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value="BasePlace对象", description="区域地点表")
public class BasePlace extends StmBaseEntity {


    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "父节点id")
    private Integer parentId;

    @ApiModelProperty(value = "层级 1 地市公司 2 工区 3 班组")
    private Integer level;

/*    @ApiModelProperty(value = "电压等级")
    private String voltageLevel;*/
}
