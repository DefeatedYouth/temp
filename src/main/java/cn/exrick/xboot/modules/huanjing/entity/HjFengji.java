package cn.exrick.xboot.modules.huanjing.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc 风机监视表 实体
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
@ApiModel(value="HjFengji对象", description="风机监视表")
public class HjFengji extends StmBaseEntity {


    private String siteId;

    private String resourcesId;

    private Date happenTime;

    @ApiModelProperty(value = "设备区域")
    private String installArea;

    @ApiModelProperty(value = "装置名称")
    private String deviceName;

    @ApiModelProperty(value = "风机状态")
    private String fengjiState;

    @ApiModelProperty(value = "通信状态")
    private String linkState;


}
