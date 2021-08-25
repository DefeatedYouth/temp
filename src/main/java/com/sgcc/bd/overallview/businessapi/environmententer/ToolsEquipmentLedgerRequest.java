package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiRequest;
import lombok.Data;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/8/25 10:28
 * @File: ToolsEquipmentLedgerRequest
 */
@Data
public class ToolsEquipmentLedgerRequest extends ApiRequest<ToolsEquipmentLedgerResponse> {

    public ToolsEquipmentLedgerRequest(){
        //super.apiCode="NA-B-2010-RE-00385";
        super.apiUrl="/jobresource-center/instruments/listToolsByFuzzyName";
        super.apiName="工器具台账模糊查询";
        super.apiDescribe="通过工器具台账名称，模糊查询工器具的台账及库存数量";
    }

    String name;

    String storageOrg;

}
