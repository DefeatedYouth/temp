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
 * @desc 变压器油色谱表 实体
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
@ApiModel(value="ByqYoushepu对象", description="变压器油色谱表")
public class ByqYoushepu extends StmBaseEntity {


    private String resourcesId;

    private String siteId;

    @ApiModelProperty(value = "变电站名称")
    private String siteName;
    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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



}
