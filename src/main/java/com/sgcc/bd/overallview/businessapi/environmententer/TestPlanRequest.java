package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiRequest;
import com.sgcc.bd.overallview.businessapi.CommonData;
import lombok.Data;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/8/20 15:13
 * @File: TestPlanRequest
 */
@Data
public class TestPlanRequest extends ApiRequest<SparePartsResponse> {

    public TestPlanRequest(){
        //super.apiCode="NA-B-2010-RE-00385";
        super.apiUrl="/jobmanage-center/inspection/plan/find/{professionalClass}";
        super.apiName="检测计划查询";
        super.apiDescribe="按照专业类别、电站名称、站房名称、线路名称、电压等级、检测类型、设备类型等参数进行查询";
    }

    private CommonData commonData;

    private String professionalClass;
}
