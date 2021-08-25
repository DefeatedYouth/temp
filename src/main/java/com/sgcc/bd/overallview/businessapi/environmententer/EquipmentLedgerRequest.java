package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiRequest;
import com.sgcc.bd.overallview.businessapi.CommonData;
import lombok.Data;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/8/25 17:38
 * @File: EquipmentLedgerRequest
 */
@Data
public class EquipmentLedgerRequest  extends ApiRequest<EquipmentLedgerResponse> {

    public EquipmentLedgerRequest(){
        //super.apiCode="NA-B-2010-RE-00385";
        super.apiUrl="/PSRCenter/queryServices/listPropertiesByFilters";
        super.apiName="设备台账查询";
        super.apiDescribe="提供以资源ID等参数查询设备资源、资产信息";
    }

   String psrId;

   String psrType;

   String professionalKind;

   CommonData commonData;

}
