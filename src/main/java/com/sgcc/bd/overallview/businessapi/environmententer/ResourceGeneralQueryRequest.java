package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiRequest;
import com.sgcc.bd.overallview.businessapi.CommonData;
import lombok.Data;

import java.util.List;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/8/25 17:29
 * @File: ResourceGeneralQueryRequest
 */
@Data
public class ResourceGeneralQueryRequest extends ApiRequest<ResourceGeneralQueryResponse> {

    public ResourceGeneralQueryRequest(){
        //super.apiCode="NA-B-2010-RE-00385";
        super.apiUrl="/PSRCenter/queryServices/commonQuery";
        super.apiName="资源通用查询";
        super.apiDescribe="提供多条件组合资源通用查询服务";
    }

    List<PsrTypeQuery> psrQuery;

    @Data
    public static class  PsrTypeQuery{

        String  psrType;

       Integer distribution;

       CommonData commonData;
    }
}
