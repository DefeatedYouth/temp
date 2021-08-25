package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/8/25 15:01
 * @File: ManufacturerFindResponse
 */
@Data
public class ManufacturerFindResponse extends ApiResponse {

    @ApiModelProperty(value = "响应数据")
    private ManufacturerFindData result;

    @Data
    public static class ManufacturerFindData{

        String manufacturerNum;

        String manufacturer;
    }

}
