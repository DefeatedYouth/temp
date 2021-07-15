package com.sgcc.bd.overallview.modules.job.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sgcc.bd.overallview.modules.job.entity.JobMaintenanceTasks;
import com.sgcc.bd.overallview.modules.job.entity.JobMaintenanceWork;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @desc  列表分页查询对象
 * @author chenfeixiang
 * @since 2021-07-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="JobMaintenanceWork查询对象", description="查询对象")
public class JobMaintenanceWorkQuery extends JobMaintenanceWork{

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "结束时间")
    private Date endTime;

}
