package cn.exrick.xboot.modules.huanjing.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @desc SF6监视表 实体
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
@ApiModel(value="HjSfsex对象", description="SF6监视表")
public class HjSfsex extends StmBaseEntity {


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

    @ApiModelProperty(value = "装置状态")
    private String deviceState;

    @ApiModelProperty(value = "描述")
    private String remark;

    @ApiModelProperty(value = "sf6浓度")
    private String sfsexValue;

    @ApiModelProperty(value = "02浓度")
    private String otwoValue;

    @ApiModelProperty(value = "报警状态 0未报警 1已报警")
    private Integer alarmState;

    @ApiModelProperty(value = "三维对应id")
    private String threeId;

}
