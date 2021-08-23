package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiRequest;
import com.sgcc.bd.overallview.businessapi.CommonData;
import lombok.Data;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/8/20 16:45
 * @File: FaultRecordRequest
 */
@Data
public class FaultRecordRequest extends ApiRequest<FaultRecordResponse> {

    public FaultRecordRequest(){
        //super.apiCode="NA-B-2010-RE-00385";
        super.apiUrl="/jobmanage-center/faultManageService/faultRecord/extendFind/{professionalClass}";
        super.apiName="故障记录查询服务(扩展)";
        super.apiDescribe="提供故障记录的查询服务，如按单位、故障线路、发生时间、技术原因、责任原因等。";
    }

    String professionalClass;

    CommonData commonData;

}
