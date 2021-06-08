package cn.exrick.xboot.modules.duanluqi.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc 断路器告警数据表 实体
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
@ApiModel(value="DlqAlarm对象", description="断路器告警数据表")
public class DlqAlarm extends StmBaseEntity {


    private String siteId;

    @ApiModelProperty(value = "设备资源Id")
    private String resourcesId;

    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    @ApiModelProperty(value = "发现时间")
    private Date happenTime;

    @ApiModelProperty(value = "告警类型")
    private String alarmType;

    @ApiModelProperty(value = "告警描述")
    private String alarmDesc;

    @ApiModelProperty(value = "状态")
    private String alarmState;


}
