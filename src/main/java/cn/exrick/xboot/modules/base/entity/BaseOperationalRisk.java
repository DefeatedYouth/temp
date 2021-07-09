package cn.exrick.xboot.modules.base.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc 操作风险表 实体
 * @author chenfeixiang
 * @since 2021-07-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value="BaseOperationalRisk对象", description="操作风险表")
public class BaseOperationalRisk extends StmBaseEntity {


    private Long siteId;

    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    @ApiModelProperty(value = "城市信息")
    private String city;

    @ApiModelProperty(value = "停电范围")
    private String powerCutScope;

    @ApiModelProperty(value = "停电计划开始时间")
    private Date startTimePlan;

    @ApiModelProperty(value = "停电计划结束时间")
    private Date endTimePlan;

    @ApiModelProperty(value = "隐患细项")
    private String hiddenDangerItems;

    @ApiModelProperty(value = "预控措施")
    private String preControlMeasures;

    @ApiModelProperty(value = "数量")
    private Integer num;


}
