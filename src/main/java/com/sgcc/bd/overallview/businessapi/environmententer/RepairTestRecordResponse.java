package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/8/26 15:30
 * @File: RepairTestRecordResponse
 */
@Data
public class RepairTestRecordResponse  extends ApiResponse {


    @ApiModelProperty(value = "响应数据")
    private RepairTestRecordRequest.RequestSearchParams  result;
}
