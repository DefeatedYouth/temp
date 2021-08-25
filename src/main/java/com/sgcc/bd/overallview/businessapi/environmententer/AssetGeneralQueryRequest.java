package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiRequest;
import com.sgcc.bd.overallview.businessapi.CommonData;
import lombok.Data;

/**
 * @description: TODO 资源通用查询
 * @author： hfl
 * @date：2021/8/25 16:14
 * @File: AssetGeneralQueryRequest
 */
@Data
public class AssetGeneralQueryRequest extends ApiRequest<AssetGeneralQueryResponse> {

    public AssetGeneralQueryRequest(){
        //super.apiCode="NA-B-2010-RE-00385";
        super.apiUrl="/ast-center/astQueryServices/{assetType}";
        super.apiName="资产通用查询";
        super.apiDescribe="指定设备类型查询，会全面查询资产信息，可以配置各种常用的条件。";
    }

    String  assetType;

    CommonData commonData;
}
