package com.sgcc.bd.overallview.modules.base.entity;

import com.sgcc.bd.overallview.base.StmBaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc 设备与摄像机的关联表 实体
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
@ApiModel(value="BaseDeviceToCamera对象", description="设备与摄像机的关联表")
public class BaseDeviceToCamera extends StmBaseEntity {


    private Long siteId;

    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    private String deviceResourcesId;

    private String cameraResourcesId;



}
