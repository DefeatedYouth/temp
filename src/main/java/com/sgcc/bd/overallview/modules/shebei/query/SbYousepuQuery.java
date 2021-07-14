package com.sgcc.bd.overallview.modules.shebei.query;

import java.util.Date;

import com.sgcc.bd.overallview.modules.shebei.entity.SbYousepu;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @desc 设备油色谱表 列表分页查询对象
 * @author chenfeixiang
 * @since 2021-06-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SbYousepu查询对象", description="设备油色谱表查询对象")
public class SbYousepuQuery extends SbYousepu{

    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "结束时间")
    private Date endTime;
//重要
}
