package cn.exrick.xboot.modules.bianyaqi.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc 变压器告警信息 实体
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
@ApiModel(value="ByqAlarm对象", description="变压器告警信息")
public class ByqAlarm extends StmBaseEntity {


    private String resourcesId;

    private String siteId;

    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    @ApiModelProperty(value = "告警类型")
    private Integer alarmType;

    @ApiModelProperty(value = "告警描述")
    private String alarmDescribe;

    @ApiModelProperty(value = "告警状态")
    private Integer state;


}
