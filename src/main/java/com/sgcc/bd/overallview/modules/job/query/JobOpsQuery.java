package com.sgcc.bd.overallview.modules.job.query;

import com.sgcc.bd.overallview.modules.job.entity.JobOps;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;

/**
 * @desc 运维作业表 列表分页查询对象
 * @author chenfeixiang
 * @since 2021-06-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="JobOps查询对象", description="运维作业表查询对象")
public class JobOpsQuery extends JobOps{












}
