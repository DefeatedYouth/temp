package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/8/25 15:52
 * @File: StandardDataQueryResponse
 */
@Data
public class StandardDataQueryResponse extends ApiResponse {

    @ApiModelProperty(value = "响应数据")
    private List<CodeData> result;

    @Data
    public static class CodeData{

        String value;

        String name;

        String dispSn;

    }

}
