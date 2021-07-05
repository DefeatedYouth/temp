package cn.exrick.xboot.modules.robot.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc 机器人履历 实体
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
@ApiModel(value="RobotResume对象", description="机器人履历")
public class RobotResume extends StmBaseEntity {


    @ApiModelProperty(value = "站点Id")
    private Long siteId;

    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    @ApiModelProperty(value = "机器人id")
    private String robotId;

    @ApiModelProperty(value = "机器人名称")
    private String robotName;

    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    @ApiModelProperty(value = "类型")
    private String requestType;

    @ApiModelProperty(value = "申请人")
    private String requestPerson;

    @ApiModelProperty(value = "申请班组")
    private String requestOrgname;

    @ApiModelProperty(value = "申请时间")
    private Date requestTime;

    @ApiModelProperty(value = "维保/检测单位")
    private String repairOrgname;

    @ApiModelProperty(value = "维保/检测时间")
    private Date repairTime;

    @ApiModelProperty(value = "维保/检测内容")
    private String repairContent;

    @ApiModelProperty(value = "审核人")
    private String checkPerson;

    @ApiModelProperty(value = "数据源id")
    private String resourcesId;

    @ApiModelProperty(value = "三维对应id")
    private String threeId;
}
