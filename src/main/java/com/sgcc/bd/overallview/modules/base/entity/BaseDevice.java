package com.sgcc.bd.overallview.modules.base.entity;

import com.sgcc.bd.overallview.base.StmBaseEntity;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @desc 主设备表 实体
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
@ApiModel(value="BaseDevice对象", description="主设备表")
public class BaseDevice extends StmBaseEntity {


    @ApiModelProperty(value = "站点Id")
    private Long siteId;

    @ApiModelProperty(value = "变电站名称")
    private String siteName;

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

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "投运日期")
    private Date runDate;

    @ApiModelProperty(value = "间隔单元")
    private String spaceUnit;

    @ApiModelProperty(value = "消防系统类型（断路器才有这个属性） 1 水喷雾灭火系统 2 细水雾灭火系统3 泡沫喷雾灭火系统 4 排油注氮灭火系统")
    private String fireFightingSystem;

    @ApiModelProperty(value = "三维对应id")
    private String threeId;

    @ApiModelProperty(value = "设备性质 一次设备 二次设备 辅助设备")
    private String equipmentNature;

    @ApiModelProperty(value = "相别")
    private String farewell;

    @ApiModelProperty(value = "健康状态（0 健康 1亚健康 2注意 3异常 4严重")
    private Integer deviceState;
}
