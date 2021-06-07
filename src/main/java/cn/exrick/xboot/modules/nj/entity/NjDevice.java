package cn.exrick.xboot.modules.nj.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import java.time.LocalDateTime;
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
 * @since 2021-06-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value="NjDevice对象", description="主设备表")
public class NjDevice extends StmBaseEntity {


    @ApiModelProperty(value = "站点Id")
    private String siteId;

    @ApiModelProperty(value = "设备编号")
    private String deviceCode;

    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    @ApiModelProperty(value = "设备类型：1=断路器；2=变压器")
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

    @ApiModelProperty(value = "投运日期")
    private LocalDateTime runDate;

    @ApiModelProperty(value = "间隔单元")
    private String spaceUnit;


}
