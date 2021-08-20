package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiRequest;
import com.sgcc.bd.overallview.businessapi.CommonData;
import lombok.Data;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/8/20 14:48
 * @File: SparePartsRequest
 */
@Data
public class SparePartsRequest extends ApiRequest<SparePartsResponse> {

    public SparePartsRequest(){
        //super.apiCode="NA-B-2010-RE-00385";
        super.apiUrl="/ast-center/spareParts/SparePartsDynamicParameter/find";
        super.apiName="备品备件动态主要参数查询服务";
        super.apiDescribe="提供备品备件动态主要参数查询服务";
    }

    private CommonData commonData;

}
