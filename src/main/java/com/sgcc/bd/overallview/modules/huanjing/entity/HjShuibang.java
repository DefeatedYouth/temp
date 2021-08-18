package com.sgcc.bd.overallview.modules.huanjing.entity;

import com.sgcc.bd.overallview.base.StmBaseEntity;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @desc 水泵监视表 实体
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
@ApiModel(value="HjShuibang对象", description="水泵监视表")
public class HjShuibang extends StmBaseEntity {


    private Long siteId;


    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    private String resourcesId;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "发生时间")
    private Date happenTime;

    @ApiModelProperty(value = "设备区域")
    private String installArea;

    @ApiModelProperty(value = "装置名称")
    private String deviceName;

    @ApiModelProperty(value = "启动方式")
    private String runType;

    @ApiModelProperty(value = "水泵状态")
    private String shuibangState;

    @ApiModelProperty(value = "电源状态")
    private String powerState;

    @ApiModelProperty(value = "回路状态")
    private String rallbackState;

    @ApiModelProperty(value = "远方/就地状态")
    private String jiudiSate;

    @ApiModelProperty(value = "开关状态值 0关 1开")
    private String switchState;

    @ApiModelProperty(value = "通信状态 0通信正常 1通信异常")
    private String linkState;


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
