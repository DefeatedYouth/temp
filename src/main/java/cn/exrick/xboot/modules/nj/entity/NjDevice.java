package cn.exrick.xboot.modules.nj.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc 主设备表 实体
 * @author chenfeixiang
 * @since 2021-06-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value="NjDevice对象", description="主设备表")
public class NjDevice extends StmBaseEntity {


    @ApiModelProperty(value = "站点Id")
    private String siteId;

    @ApiModelProperty(value = "设备编号")
    private String deviceCode;

    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    @ApiModelProperty(value = "设备类型：1=变压器；2=断路器，3=电抗器，4=电流互感器，5=电压互感器，6=隔离开关，7=避雷器，8=组合电器")
    private String deviceType;

    @ApiModelProperty(value = "资源id")
    private String resourcesId;

    @ApiModelProperty(value = "所属地市")
    private String cityOrgname;

    @ApiModelProperty(value = "运维单位")
    private String workOrgname;

    @ApiModelProperty(value = "维护班组")
    private String workBanzhu;

    @ApiModelProperty(value = "生产厂家")
    private String manufacturer;

    @ApiModelProperty(value = "额定电压")
    private String ratedVoltage;

    @ApiModelProperty(value = "电压等级")
    private String voltageLevel;

    @ApiModelProperty(value = "投运日期")
    private Date runDate;

    @ApiModelProperty(value = "间隔单元")
    private String spaceUnit;


}
