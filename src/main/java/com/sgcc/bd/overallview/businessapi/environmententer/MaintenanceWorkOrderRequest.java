package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiRequest;
import lombok.Data;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/8/26 15:15
 * @File: MaintenanceWorkOrderRequest
 */
@Data
public class MaintenanceWorkOrderRequest extends ApiRequest<MaintenanceWorkOrderResponse> {

    public MaintenanceWorkOrderRequest(){

        //super.apiCode="NA-B-2010-RE-00385";
        super.apiUrl="/WMCenter/maintenance/workOrderQuery";
        super.apiName="检修工单查询";
        super.apiDescribe="提供检修工单列表查询服务能力";

    }

    String professionalClass;

    String objId;

}
