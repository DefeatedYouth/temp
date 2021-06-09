package cn.exrick.xboot.modules.base.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

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


    private String siteId;

    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    private String deviceResourcesId;

    private String cameraResourcesId;



}
