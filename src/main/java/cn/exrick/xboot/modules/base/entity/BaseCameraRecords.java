package cn.exrick.xboot.modules.base.entity;

import cn.exrick.xboot.base.StmBaseEntity;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @desc  摄像机录像识别记录表 实体
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
@ApiModel(value="BaseCameraRecords对象", description=" 摄像机录像识别记录表")
public class BaseCameraRecords extends StmBaseEntity {


    private String resourcesId;

    private String siteId;

    @ApiModelProperty(value = "摄像机名称")
    private String cameraName;

    private String cameraIp;

    private String cameraPort;

    @ApiModelProperty(value = "录像时间")
    private Date videoTime;

    @ApiModelProperty(value = "视频名称")
    private String videoName;

    @ApiModelProperty(value = "识别结果")
    private String videoResult;

    @ApiModelProperty(value = "录像播放Url")
    private String videoUrl;


}