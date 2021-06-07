package cn.exrick.xboot.modules.nj.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc 设备与摄像机的关联表 实体
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
@ApiModel(value="NjDeviceToCamera对象", description="设备与摄像机的关联表")
public class NjDeviceToCamera extends StmBaseEntity {


    private String siteId;

    private String deviceCode;

    private String cameraCode;


}
