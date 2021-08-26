package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiRequest;
import lombok.Data;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/8/26 16:12
 * @File: RepairTestRecordViewRequest
 */
@Data
public class RepairTestRecordViewRequest extends ApiRequest<RepairTestRecordViewResponse> {

    public RepairTestRecordViewRequest(){

        //super.apiCode="NA-B-2010-RE-00385";
        super.apiUrl="/WMCenter/examineRepair/checkRepairTest";
        super.apiName="修试记录查看";
        super.apiDescribe="提供查看单条修试记录详细信息服务能力";

    }

    String professionalClass;

    String objId;

}
