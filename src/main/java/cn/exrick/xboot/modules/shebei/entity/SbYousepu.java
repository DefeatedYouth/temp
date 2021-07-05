package cn.exrick.xboot.modules.shebei.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc 设备油色谱表 实体
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
@ApiModel(value="SbYousepu对象", description="设备油色谱表")
public class SbYousepu extends StmBaseEntity {


    private String resourcesId;

    private Long siteId;

    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    @ApiModelProperty(value = "监测时间")
    private Date monitoringTime;

    @ApiModelProperty(value = "氢气")
    private String hydrogen;

    @ApiModelProperty(value = "二氧化碳")
    private String carbonDioxide;

    @ApiModelProperty(value = "一氧化碳")
    private String carbonMonoxide;

    @ApiModelProperty(value = "乙烷")
    private String ethane;

    @ApiModelProperty(value = "甲烷")
    private String methane;

    @ApiModelProperty(value = "乙烯")
    private String ethylene;

    @ApiModelProperty(value = "乙炔")
    private String acetylene;

    @ApiModelProperty(value = "总烃")
    private String totalHydrocarbon;

    @ApiModelProperty(value = "氮气")
    private String nitrogen;

    @ApiModelProperty(value = "设备类型")
    private Integer deviceType;

    @ApiModelProperty(value = "三维对应id")
    private String threeId;
}
