package cn.exrick.xboot.modules.nj.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc  摄像机表 实体
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
@ApiModel(value="NjCamera对象", description=" 摄像机表")
public class NjCamera extends StmBaseEntity {


    private String siteId;

    @ApiModelProperty(value = "摄像机名称")
    private String cameraName;

    @ApiModelProperty(value = "摄像机IP")
    private String cameraIp;

    @ApiModelProperty(value = "摄像机端口")
    private String cameraPort;


}
