package com.sgcc.bd.overallview.modules.shebei.entity;

import com.sgcc.bd.overallview.base.StmBaseEntity;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc 备品备件表 实体
 * @author chenfeixiang
 * @since 2021-07-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value="SbSparePartsList对象", description="备品备件表")
public class SbSparePartsList extends StmBaseEntity {


    private Long siteId;

    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    @ApiModelProperty(value = "设备类型")
    private Integer deviceType;

    @ApiModelProperty(value = "电压等级")
    private String voltageLevel;

    @ApiModelProperty(value = "部门名称")
    private String deparentName;

    @ApiModelProperty(value = "入库时间")
    private Date storageDate;

    @ApiModelProperty(value = "设备编码")
    private String equipmentCode;

    @ApiModelProperty(value = "物料数量")
    private String materialQuantity;

    @ApiModelProperty(value = "物料描述")
    private String materialDescription;

    @ApiModelProperty(value = "物资明细ID")
    private Long materialDetailsId;


}
