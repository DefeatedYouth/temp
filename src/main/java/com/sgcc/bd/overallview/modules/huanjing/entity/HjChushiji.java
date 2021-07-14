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
 * @desc 除湿机监视表 实体
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
@ApiModel(value="HjChushiji对象", description="除湿机监视表")
public class HjChushiji extends StmBaseEntity {


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

    @ApiModelProperty(value = "通信状态 0通信正常 1通信异常")
    private Integer linkState;

    @ApiModelProperty(value = "工作状态 0关 1开")
    private Integer workState;

    @ApiModelProperty(value = "监测温度")
    private String wenduValue;

    @ApiModelProperty(value = "监测湿度")
    private String shiduValue;

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
