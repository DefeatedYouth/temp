package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiRequest;
import com.sgcc.bd.overallview.businessapi.CommonData;
import lombok.Data;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/8/25 17:46
 * @File: ResourceInformationByIdRequest
 */
@Data
public class ResourceInformationByIdRequest extends ApiRequest<ResourceInformationByIdResponse> {

    public ResourceInformationByIdRequest(){
        //super.apiCode="NA-B-2010-RE-00385";
        super.apiUrl="/PSRCenter/psrQueryServices/getPsrById";
        super.apiName="根据ID查询资源信息";
        super.apiDescribe="根据资源类型和资源ID查询资源信息";
    }

    Integer professionalKind;

    String id;

    String psrType;

    CommonData commonData;

}
