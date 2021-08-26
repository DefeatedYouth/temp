package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @description: TODO 隐患查询
 * @author： hfl
 * @date：2021/8/26 10:39
 * @File: InspectionPlanResponse
 */
@Data
public class InspectionPlanResponse extends ApiResponse {

    @ApiModelProperty(value = "响应数据")
    private List<InspectionPlanRequest.InspectionPlan> result;
}
