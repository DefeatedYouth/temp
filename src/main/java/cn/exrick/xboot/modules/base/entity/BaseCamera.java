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
 * @desc  摄像机表 实体
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
@ApiModel(value="BaseCamera对象", description=" 摄像机表")
public class BaseCamera extends StmBaseEntity {


    private String resourcesId;

    private Long siteId;


    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    @ApiModelProperty(value = "摄像机名称")
    private String cameraName;

    @ApiModelProperty(value = "摄像机IP")
    private String cameraIp;

    @ApiModelProperty(value = "摄像机端口")
    private String cameraPort;

    @ApiModelProperty(value = "三维对应id")
    private String threeId;
}
