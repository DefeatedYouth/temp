package com.sgcc.bd.overallview.modules.shebei.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.sgcc.bd.overallview.base.StmBaseEntity;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc 断路器设备台账 实体
 * @author chenfeixiang
 * @since 2021-06-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value="SbBook对象", description="断路器设备台账")
public class SbBook extends StmBaseEntity {


    private String resourcesId;

    private Long siteId;

    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    @ApiModelProperty(value = "设备名称")
    private String deviceName;
    @ApiModelProperty(value = "设备类型")
    private Integer deviceType;

    @ApiModelProperty(value = "所属地区")
    private String region;

    @ApiModelProperty(value = "运维单位")
    private String maintenanceUnit;

    @ApiModelProperty(value = "维护班组")
    private String maintenanceTeam;

    @ApiModelProperty(value = "电压等级")
    private String voltageLevel;

    @ApiModelProperty(value = "相别")
    private String farewell;

    @ApiModelProperty(value = "额定短路开关电流")
    private String openCloseCurrent;

    @ApiModelProperty(value = "结构形式")
    private String structureType;

    @ApiModelProperty(value = "生产厂家")
    private String manufacturer;

    @ApiModelProperty(value = "设备型号")
    private String equipmentModel;

    @ApiModelProperty(value = "投运日期")
    private Date useTime;

    @ApiModelProperty(value = "资产性质")
    private String natureAssets;

    @ApiModelProperty(value = "资产单位")
    private String assetUnit;

    @ApiModelProperty(value = "资产编号")
    private String assetNumber;

    @ApiModelProperty(value = "工程编号")
    private String projectNumber;

    @ApiModelProperty(value = "工程名称")
    private String projectName;

    @ApiModelProperty(value = "设备增加方式")
    private String equipmentIncreaseMode;

    @ApiModelProperty(value = "流水码")
    private String streamCode;

    @ApiModelProperty(value = "实物id")
    private String materialId;

    @ApiModelProperty(value = "wbs编码")
    private String wbsCode;

    @ApiModelProperty(value = "运行编号")
    private String operationNumber;

    @ApiModelProperty(value = "间隔单元")
    private String spacerUnit;

    @ApiModelProperty(value = "设备主人")
    private String equipmentOwner;

    @ApiModelProperty(value = "设备状态")
    private String deviceState;

    @ApiModelProperty(value = "相数")
    private String farewellNum;

    @ApiModelProperty(value = "用途")
    private String purpose;

    @ApiModelProperty(value = "最近投运日期")
    private Date latelyUseTime;

    @ApiModelProperty(value = "是否农网")
    private String isAgriculture;

    @ApiModelProperty(value = "使用环境")
    private String useEnvironment;

    @ApiModelProperty(value = "安装位置")
    private String installationPosition;

    @ApiModelProperty(value = "专业分类")
    private String majorClassification;

    @ApiModelProperty(value = "开关编号")
    private String switchNumber;

    @ApiModelProperty(value = "出厂编号")
    private String factoryNumber;

    @ApiModelProperty(value = "出厂日期")
    private Date factoryDate;

    @ApiModelProperty(value = "产品代号")
    private String productCode;

    @ApiModelProperty(value = "制造国家")
    private String manufacturingCountry;

    @ApiModelProperty(value = "额定电压等级")
    private String ratedVoltage;

    @ApiModelProperty(value = "额定电流")
    private String ratedCurrent;

    @ApiModelProperty(value = "额定频率")
    private String ratedFrequency;

    @ApiModelProperty(value = "绝缘耐热等级")
    private String insulationClass;

    @ApiModelProperty(value = "防污等级")
    private String antifoulingGrade;

    @ApiModelProperty(value = "绝缘介质")
    private String insulatingMedium;

    @ApiModelProperty(value = "三维对应id")
    private String threeId;

    @ApiModelProperty(value = "设备容量")
    private String equipmentCapacity;

    @ApiModelProperty(value = "消防装置")
    private String fireFightingEquipment;

    @TableField(exist = false)
    @ApiModelProperty(value = "同厂家设备数量")
    private String num;
}
