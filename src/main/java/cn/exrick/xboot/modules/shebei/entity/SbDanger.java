package cn.exrick.xboot.modules.shebei.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc 断路器隐患信息表 实体
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
@ApiModel(value="SbDanger对象", description="断路器隐患信息表")
public class SbDanger extends StmBaseEntity {


    private String resourcesId;

    private Long siteId;

    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    @ApiModelProperty(value = "隐患编号")
    private String hiddenDangerNumber;

    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    @ApiModelProperty(value = "设备类型")
    private Integer deviceType;

    @ApiModelProperty(value = "发现人")
    private String foundMan;

    @ApiModelProperty(value = "发现时间")
    private Date foundTime;

    @ApiModelProperty(value = "隐患等级")
    private String hiddenDangerLevel;

    @ApiModelProperty(value = "隐患类型")
    private String hiddenDangerType;

    @ApiModelProperty(value = "隐患描述")
    private String hiddenDangerDescription;

    @ApiModelProperty(value = "采取措施")
    private String takeSteps;

    @ApiModelProperty(value = "隐患来源")
    private String hiddenDangerSource;

    @ApiModelProperty(value = "是否是共性隐患")
    private Integer commonHiddenDanger;

    @ApiModelProperty(value = "隐患状态")
    private String hiddenDangerState;


}
