package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/8/25 15:10
 * @File: DeviceModelCodeResponse
 */
@Data
public class DeviceModelCodeResponse extends ApiResponse {

    @ApiModelProperty(value = "响应数据")
    private EquipModel result;

    @Data
    public static class EquipModel{

        String psrType;

        String model;

        String modelNum;
    }
}
