package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiRequest;
import com.sgcc.bd.overallview.businessapi.CommonData;
import lombok.Data;

import java.util.Date;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/8/20 15:41
 * @File: InspectionReportMaintenance
 */
@Data
public class InspectionReportMaintenanceRequest extends ApiRequest<FindMeteorologyResponse> {

    public InspectionReportMaintenanceRequest(){
        //super.apiCode="NA-B-2010-RE-00385";
        super.apiUrl="/jobmanage-center/liveWorkScheme/find/{professionalClass}";
        super.apiName="带电作业方案查询";
        super.apiDescribe="带电作业方案查询";
    }
    String professionalClass;

    CommonData commonData;
}
