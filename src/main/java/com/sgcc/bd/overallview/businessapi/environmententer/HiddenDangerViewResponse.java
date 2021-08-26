package com.sgcc.bd.overallview.businessapi.environmententer;
import com.sgcc.bd.overallview.businessapi.ApiResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * @description: TODO 检修工单查询
 * @author： hfl
 * @date：2021/8/26 14:42
 * @File: HiddenDangerViewResponse
 */
@Data
public class HiddenDangerViewResponse  extends ApiResponse {

    @ApiModelProperty(value = "响应数据")
    private  HiddenDangerRequest.Params params;
}
