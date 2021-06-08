package cn.exrick.xboot.modules.bianyaqi.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc 设备履历故障记录表 实体
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value="ByqFault对象", description="设备履历故障记录表")
public class ByqFault extends StmBaseEntity {


    private String resourcesId;

    @ApiModelProperty(value = "故障记录ID")
    private String faultId;

    private String siteId;

    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    @ApiModelProperty(value = "故障时间")
    private String breakdownTime;

    @ApiModelProperty(value = "故障类型")
    private Integer type;

    @ApiModelProperty(value = "生产厂家")
    private String manufacturer;

    @ApiModelProperty(value = "故障描述")
    private String description;

    @ApiModelProperty(value = "处理人")
    private String handler;

    @ApiModelProperty(value = "处理时间")
    private String handTime;

    @ApiModelProperty(value = "故障状态")
    private String state;


}
