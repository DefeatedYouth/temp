package cn.exrick.xboot.modules.robot.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc 机器人台账表 实体
 * @author chenfeixiang
 * @since 2021-06-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value="RobotBook对象", description="机器人台账表")
public class RobotBook extends StmBaseEntity {


    @ApiModelProperty(value = "站点Id")
    private Long siteId;

    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    @ApiModelProperty(value = "机器人Id")
    private String robotId;

    @ApiModelProperty(value = "机器人名称")
    private String robotName;

    @ApiModelProperty(value = "使用单位")
    private String useOrgname;

    @ApiModelProperty(value = "所属班组")
    private String useBanzhuname;

    @ApiModelProperty(value = "使用类型")
    private String useType;

    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    @ApiModelProperty(value = "生产厂家")
    private String manufacturer;

    @ApiModelProperty(value = "安装位置")
    private String installArea;

    @ApiModelProperty(value = "设备型号")
    private String deviceModel;

    @ApiModelProperty(value = "生产日期")
    private Date buildDate;

    @ApiModelProperty(value = "设备来源")
    private String deviceFrom;

    @ApiModelProperty(value = "出场编号")
    private String outNumber;

    @ApiModelProperty(value = "出厂日期")
    private Date outDate;

    @ApiModelProperty(value = "正式投运日")
    private Date runDate;

    @ApiModelProperty(value = "设备状态")
    private String deviceState;

    @ApiModelProperty(value = "数据源id")
    private String resourcesId;

    @ApiModelProperty(value = "三维对应id")
    private String threeId;
}
