package cn.exrick.xboot.modules.base.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @desc 站点表 实体
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
@ApiModel(value="BaseSite对象", description="站点表")
public class BaseSite extends StmBaseEntity {

    @ApiModelProperty(value = "区域地点Id")
    private Long placeId;

    @ApiModelProperty(value = "站点Id")
    private Long siteId;

    @ApiModelProperty(value = "站点名称")
    private String siteName;

    @ApiModelProperty(value = "主接线图")
    private String svgpicFile;

    @ApiModelProperty(value = "温度")
    private String temperature;

    @ApiModelProperty(value = "湿度")
    private String humidity;

    @ApiModelProperty(value = "风向")
    private String windDirection;

    @ApiModelProperty(value = "风速")
    private String windSpeed;

    @ApiModelProperty(value = "气压")
    private String pressure;


    @ApiModelProperty(value = "降水量")
    private String precipitation;


    @ApiModelProperty(value = "通信状态")
    private String communicationStatus;


    @ApiModelProperty(value = "天气状态")
    private String weatherConditions;

    @ApiModelProperty(value = "交直流系统监视图")
    private String systemMonitoring;

}
