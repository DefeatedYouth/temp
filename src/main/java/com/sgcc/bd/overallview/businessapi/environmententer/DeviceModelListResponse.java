package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/8/25 15:33
 * @File: DeviceModelListResponse
 */
@Data
public class DeviceModelListResponse  extends ApiResponse {

    @ApiModelProperty(value = "响应数据")
    private DeviceModelListData result;

    @Data
    public static class DeviceModelListData{

        Integer total;

        Integer size;

        Integer current;

        Integer pages;

        List<EquipModelData> records;

    }

    @Data
    public static class EquipModelData{

        String psrType;

        String model;

        String modelNum;

    }
}
