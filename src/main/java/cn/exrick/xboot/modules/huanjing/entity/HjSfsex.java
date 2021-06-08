package cn.exrick.xboot.modules.huanjing.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc SF6监视表 实体
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
@ApiModel(value="HjSfsex对象", description="SF6监视表")
public class HjSfsex extends StmBaseEntity {


    private String siteId;

    private String resourcesId;

    @ApiModelProperty(value = "发生时间")
    private Date happenTime;

    @ApiModelProperty(value = "设备区域")
    private String installArea;

    @ApiModelProperty(value = "装置名称")
    private String deviceName;

    @ApiModelProperty(value = "通信状态")
    private String linkState;

    @ApiModelProperty(value = "装置状态")
    private String deviceState;

    @ApiModelProperty(value = "描述")
    private String remark;

    @ApiModelProperty(value = "sf6浓度")
    private String sfsexValue;

    @ApiModelProperty(value = "02浓度")
    private String otwoValue;


}