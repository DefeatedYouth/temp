package cn.exrick.xboot.modules.job.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc 工作票表 实体
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
@ApiModel(value="JobTicket对象", description="工作票表")
public class JobTicket extends StmBaseEntity {


    private String siteId;

    @ApiModelProperty(value = "工作票名称")
    private Date ticketName;

    @ApiModelProperty(value = "工作票类型")
    private String ticketType;

    @ApiModelProperty(value = "工作票号")
    private String ticketNumber;

    @ApiModelProperty(value = "工作负责人")
    private String ticketPerson;

    @ApiModelProperty(value = "工作班组")
    private String ticketBanzhu;

    @ApiModelProperty(value = "工作人单位")
    private String ticketOrgname;

    @ApiModelProperty(value = "工作地点及双重名称")
    private String ticketAddress;

    @ApiModelProperty(value = "工作内容")
    private String ticketContent;

    @ApiModelProperty(value = "计划工作时间")
    private Date ticketPlanTime;

    @ApiModelProperty(value = "完成状态")
    private String ticketState;


}
