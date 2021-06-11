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
 * @desc 变压器隐患信息表 实体
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
@ApiModel(value="ByqDanger对象", description="变压器隐患信息表")
public class ByqDanger extends StmBaseEntity {


    private String resourcesId;

    private Long siteId;

    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    @ApiModelProperty(value = "隐患编号")
    private String hiddenDangerNumber;

    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    @ApiModelProperty(value = "设备类型")
    private String deviceType;

    @ApiModelProperty(value = "发现人")
    private String foundMan;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
