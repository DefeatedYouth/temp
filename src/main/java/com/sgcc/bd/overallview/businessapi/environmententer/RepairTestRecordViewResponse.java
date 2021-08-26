package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/8/26 16:12
 * @File: RepairTestRecordViewResponse
 */
@Data
public class RepairTestRecordViewResponse  extends ApiResponse {

    @ApiModelProperty(value = "响应数据")
    private RepairTestRecordRequest.RequestSearchParams  result;

}
