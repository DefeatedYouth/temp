package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @description: TODO 根据ID查询资源信息
 * @author： hfl
 * @date：2021/8/25 17:38
 * @File: EquipmentLedgerResponse
 */
@Data
public class EquipmentLedgerResponse extends ApiResponse {

    @ApiModelProperty(value = "响应数据")
    private List<List<Map<String, Object>>> result;

}
