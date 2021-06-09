package cn.exrick.xboot.modules.duanluqi.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @desc 设备履历故障记录表 实体
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
@ApiModel(value="DlqFault对象", description="设备履历故障记录表")
public class DlqFault extends StmBaseEntity {


    private String resourcesId;

    private String siteId;

    private String faultId;

    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    @ApiModelProperty(value = "故障时间")
    private String breakdownTime;

    @ApiModelProperty(value = "故障类型")
    private Integer type;

    @ApiModelProperty(value = "生产厂家")
    private String manufacturer;

    @ApiModelProperty(value = "故障描述")
    private String description;

    @ApiModelProperty(value = "处理人")
    private String handler;

    @ApiModelProperty(value = "处理时间")
    private String handTime;

    @ApiModelProperty(value = "故障状态")
    private String state;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "缺陷等级")
    private String defectLevel;
}
