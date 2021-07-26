package com.sgcc.bd.overallview.common.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author chenfeixiang6@163.com
 * @date 2021/6/7
 * @desc
 */
@Data
public class BaseReqVO {
    @ApiModelProperty(value = "唯一标识")
    private Integer id ;
    @ApiModelProperty(value = "唯一标识")
    private List<String> ids ;

    @ApiModelProperty(value = "设备类型")
    private String type;

    @ApiModelProperty(value = "变电站id")
    private Long siteId;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "结束时间")
    private Date endTime;
}
