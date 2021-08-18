package com.sgcc.bd.overallview.modules.anxiaofang.entity;

import com.sgcc.bd.overallview.base.StmBaseEntity;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @desc 安消防设备监视表 实体
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
@ApiModel(value="AxfDevice对象", description="安消防设备监视表")
public class AxfDevice extends StmBaseEntity {


    private String resourcesId;

    private Long siteId;

    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "发生时间")
    private Date happenTime;

    @ApiModelProperty(value = "设备区域")
    private String installArea;

    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    @ApiModelProperty(value = "设备类型")
    private String deviceType;

    @ApiModelProperty(value = "节点类型  0布防状态 1撤防状态")
    private String nodeType;

    @ApiModelProperty(value = "设备状态（0装置故障 1通信异常）")
    private String deviceState;

    @ApiModelProperty(value = "事件描述")
    private String eventDesc;

    @ApiModelProperty(value = "通信状态")
    private String linkState;

    @ApiModelProperty(value = "报警状态")
    private String alarmState;

    @ApiModelProperty(value = "实时数据")
    private String realdata;

    @ApiModelProperty(value = "节点名称")
    private String nodeName;

    @ApiModelProperty(value = "开启状态0关闭1开启")
    private String openFlag;

    @ApiModelProperty(value = "运维班组名称")
    private String operationMaintenanceTeam;

    @ApiModelProperty(value = "三维id")
    private String threeId;
}
