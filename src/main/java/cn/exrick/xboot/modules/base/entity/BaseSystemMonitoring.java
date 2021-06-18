package cn.exrick.xboot.modules.base.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc 交直流系统监视表 实体
 * @author chenfeixiang
 * @since 2021-06-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value="BaseSystemMonitoring对象", description="交直流系统监视表")
public class BaseSystemMonitoring extends StmBaseEntity {


    private String resourcesId;

    private Long siteId;

    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    @ApiModelProperty(value = "项目名称")
    private String projectName;

    @ApiModelProperty(value = "量测值")
    private String measuredValue;

    @ApiModelProperty(value = "单位")
    private String company;

    @ApiModelProperty(value = "1 交流系统量测 2不间断系统量测 3直流系统量测")
    private Integer type;


}
