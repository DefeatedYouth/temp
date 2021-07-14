package com.sgcc.bd.overallview.modules.base.entity;

import com.sgcc.bd.overallview.base.StmBaseEntity;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

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

    private Long siteId;


    @ApiModelProperty(value = "变电站名称")
    private String siteName;

    @ApiModelProperty(value = "摄像机名称")
    private String cameraName;

    private String cameraIp;

    private String cameraPort;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "录像时间")
    private Date videoTime;

    @ApiModelProperty(value = "视频名称")
    private String videoName;

    @ApiModelProperty(value = "识别结果")
    private String videoResult;

    @ApiModelProperty(value = "录像播放Url")
    private String videoUrl;


}
