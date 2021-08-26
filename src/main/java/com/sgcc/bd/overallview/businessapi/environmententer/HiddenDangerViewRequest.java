package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiRequest;
import lombok.Data;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/8/26 14:42
 * @File: HiddenDangerViewRequest
 */
@Data
public class HiddenDangerViewRequest extends ApiRequest<HiddenDangerViewResponse> {

    public HiddenDangerViewRequest(){

        //super.apiCode="NA-B-2010-RE-00385";
        super.apiUrl="/WMCenter/hazard/queryHazard";
        super.apiName="隐患查询";
        super.apiDescribe="提供查看单条隐患详细信息服务能力";

    }

    String objId;

    String professionalClass;

}
