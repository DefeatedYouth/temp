package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiRequest;
import lombok.Data;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/8/25 15:51
 * @File: StandardDataQueryRequest
 */
@Data
public class StandardDataQueryRequest extends ApiRequest<StandardDataQueryResponse> {

    public StandardDataQueryRequest(){
        //super.apiCode="NA-B-2010-RE-00385";
        super.apiUrl="/baseCenter/model/modelCodes";
        super.apiName="标准数据查询";
        super.apiDescribe="标准数据查询";
    }

    String codeType;

}
