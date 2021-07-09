package cn.exrick.xboot.modules.shebei.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc 二次设备监视表 实体
 * @author chenfeixiang
 * @since 2021-07-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value="SbSecondaryEquipmentMonitoring对象", description="二次设备监视表")
public class SbSecondaryEquipmentMonitoring extends StmBaseEntity {


    @ApiModelProperty(value = "站点Id")
    private Long siteId;

    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    @ApiModelProperty(value = "屏柜选择")
    private String cabinetSelection;

    @ApiModelProperty(value = "二次设备类型")
    private String deviceType;

    @ApiModelProperty(value = "二次设备名称")
    private String deviceName;

    @ApiModelProperty(value = "状态")
    private Integer state;


}
