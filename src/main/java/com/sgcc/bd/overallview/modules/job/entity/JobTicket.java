package com.sgcc.bd.overallview.modules.job.entity;

import com.sgcc.bd.overallview.base.StmBaseEntity;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

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

    private Long siteId;

    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    @ApiModelProperty(value = "工作票名称")
    private String ticketName;

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

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "计划工作时间")
    private Date ticketPlanTime;

    @ApiModelProperty(value = "完成状态")
    private String ticketState;

    @ApiModelProperty(value = "许可人")
    private String permitPersion;

    @ApiModelProperty(value = "许可时间")
    private String permitPersionTime;

    @ApiModelProperty(value = "城市")
    private String city;

    @ApiModelProperty(value = "编号")
    private String number;

 /*   @ApiModelProperty(value = "结束时间")
    private String endTime;*/
}
