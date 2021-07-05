package cn.exrick.xboot.modules.shebei.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc 设备带电测试记录表 实体
 * @author chenfeixiang
 * @since 2021-06-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value="SbLiveDetection对象", description="设备带电测试记录表")
public class SbLiveDetection extends StmBaseEntity {


    private String resourcesId;

    private Long siteId;

    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    @ApiModelProperty(value = "变电站上级id")
    private Integer parentId;

    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    @ApiModelProperty(value = "设备类型")
    private String deviceType;

    @ApiModelProperty(value = "生产厂家")
    private String manufactor;

    @ApiModelProperty(value = "工作班组")
    private String workingTeam;

    @ApiModelProperty(value = "检测日期")
    private Date testTime;

    @ApiModelProperty(value = "检测日期")
    private String testItems;

    @ApiModelProperty(value = "结论")
    private String conclusion;

    @ApiModelProperty(value = "所属电站")
    private String parentName;

    @ApiModelProperty(value = "所属城市")
    private String city;

    @ApiModelProperty(value = "附件地址")
    private String attachment;

    @ApiModelProperty(value = "三维对应id")
    private String threeId;
}
