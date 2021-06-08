package cn.exrick.xboot.modules.duanluqi.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc 断路器实时状态数据表 实体
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
@ApiModel(value="DlqRealdata对象", description="断路器实时状态数据表")
public class DlqRealdata extends StmBaseEntity {


    private String resourcesId;

    private String siteId;

    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    @ApiModelProperty(value = "监测时间")
    private Date monitoringTime;

    @ApiModelProperty(value = "开合状态")
    private Integer openingClosingState;


}
