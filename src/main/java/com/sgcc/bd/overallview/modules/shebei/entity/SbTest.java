package com.sgcc.bd.overallview.modules.shebei.entity;

import com.sgcc.bd.overallview.base.StmBaseEntity;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc 断路器履历实验信息表 实体
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
@ApiModel(value="SbTest对象", description="断路器履历实验信息表")
public class SbTest extends StmBaseEntity {


    private String resourcesId;

    private Long siteId;

    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    @ApiModelProperty(value = "设备类型")
    private Integer deviceType;

    @ApiModelProperty(value = "生产厂家")
    private String manufactor;

    @ApiModelProperty(value = "试验专业")
    private String experimentSpecialty;

    @ApiModelProperty(value = "实验性质")
    private Date natureTest;

    @ApiModelProperty(value = "实验名称")
    private String testName;

    @ApiModelProperty(value = "实验时间")
    private String testTime;

    @ApiModelProperty(value = "试验结论")
    private Integer testConclusion;

    @ApiModelProperty(value = "试验状态")
    private String testStatus;

    @ApiModelProperty(value = "附件地址")
    private String attachmentAddress;

    @ApiModelProperty(value = "录入人")
    private String inputMan;

    @ApiModelProperty(value = "三维对应id")
    private String threeId;
}
