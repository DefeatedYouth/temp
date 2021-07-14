package com.sgcc.bd.overallview.modules.huanjing.entity;

import com.sgcc.bd.overallview.base.StmBaseEntity;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc 灯光监视表 实体
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
@ApiModel(value="HjDengguang对象", description="灯光监视表")
public class HjDengguang extends StmBaseEntity {


    private Long siteId;

    private String resourcesId;


    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    @ApiModelProperty(value = "发生时间")
    private Date happenTime;

    @ApiModelProperty(value = "设备区域")
    private String installArea;

    @ApiModelProperty(value = "装置名称")
    private String deviceName;

    @ApiModelProperty(value = "开关状态值 0关 1开")
    private Integer switchState;

    @ApiModelProperty(value = "通信状态 0通信正常 1通信异常")
    private Integer linkState;


    @ApiModelProperty(value = "运维班id")
    private Integer parentId;

    @ApiModelProperty(value = "运维班名称")
    private String parentName;

    @ApiModelProperty(value = "节点名称")
    private String noteName;

    @ApiModelProperty(value = "节点类型")
    private String noteType;

    @ApiModelProperty(value = "三维对应id")
    private String threeId;
}
