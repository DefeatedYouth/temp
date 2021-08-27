package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiRequest;
import com.sgcc.bd.overallview.businessapi.ApiResponse;
import com.sgcc.bd.overallview.businessapi.CommonData;
import lombok.Data;

/**
 * @description: TODO 变压器
 * @author： hfl
 * @date：2021/8/27 17:28
 * @File: TransformerRequest
 */
@Data
public class TransformerRequest  extends ApiRequest<TransformerResponse> {
    public TransformerRequest(){
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
