package cn.exrick.xboot.modules.shebei.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc 断路器告警数据表 实体
 * @author chenfeixiang
 * @since 2021-06-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value="SbAlarm对象", description="断路器告警数据表")
public class SbAlarm extends StmBaseEntity {


    private Long siteId;

    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    @ApiModelProperty(value = "设备资源Id")
    private String resourcesId;

    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    @ApiModelProperty(value = "设备类型")
    private Integer deviceType;

    @ApiModelProperty(value = "发现时间")
    private Date alarmTime;

    @ApiModelProperty(value = "告警类型(0 正常 1 事故告警 2 异常告警 3 越线告警 4 变位告警 5 告知告警)")
    private Integer alarmType;

    @ApiModelProperty(value = "告警描述")
    private String alarmDesc;

    @ApiModelProperty(value = "状态 0未处理 1已处理")
    private Integer alarmState;

    @ApiModelProperty(value = "间隔名称")
    private String  placeName;

    @ApiModelProperty(value = "三维对应id")
    private String threeId;
}
