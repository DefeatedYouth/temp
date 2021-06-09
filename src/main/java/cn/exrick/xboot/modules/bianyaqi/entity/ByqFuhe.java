package cn.exrick.xboot.modules.bianyaqi.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @desc 变压器负荷信息表 实体
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
@ApiModel(value="ByqFuhe对象", description="变压器负荷信息表")
public class ByqFuhe extends StmBaseEntity {


    private String resourcesId;

    private String siteId;


    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "监测时间")
    private Date monitoringTime;

    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    @ApiModelProperty(value = "A相电压")
    private String avoltage;

    @ApiModelProperty(value = "B相电压")
    private String bvoltage;

    @ApiModelProperty(value = "C相电压")
    private String cvoltage;

    @ApiModelProperty(value = "A相电流")
    private String aelectric;

    @ApiModelProperty(value = "B相电流")
    private String belectric;

    @ApiModelProperty(value = "C相电流")
    private String celectric;

    @ApiModelProperty(value = "有功功率")
    private String activePower;

    @ApiModelProperty(value = "无功功率")
    private String reactivePower;

    @ApiModelProperty(value = "负载率")
    private String loadRate;





}
