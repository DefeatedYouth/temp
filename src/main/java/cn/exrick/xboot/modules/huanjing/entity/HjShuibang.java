package cn.exrick.xboot.modules.huanjing.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc 水泵监视表 实体
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
@ApiModel(value="HjShuibang对象", description="水泵监视表")
public class HjShuibang extends StmBaseEntity {


    private String siteId;

    private String resourcesId;

    @ApiModelProperty(value = "发生时间")
    private Date happenTime;

    @ApiModelProperty(value = "设备区域")
    private String installArea;

    @ApiModelProperty(value = "装置名称")
    private String deviceName;

    @ApiModelProperty(value = "启动方式")
    private String runType;

    @ApiModelProperty(value = "水泵状态")
    private String shuibangState;

    @ApiModelProperty(value = "电源状态")
    private String powerState;

    @ApiModelProperty(value = "回路状态")
    private String rallbackState;

    @ApiModelProperty(value = "远方/就地状态")
    private String jiudiSate;


}
