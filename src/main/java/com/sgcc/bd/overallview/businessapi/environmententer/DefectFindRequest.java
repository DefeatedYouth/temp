package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiRequest;
import com.sgcc.bd.overallview.businessapi.CommonData;
import lombok.Data;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/8/25 14:33
 * @File: DefectFindRequest
 */
@Data
public class DefectFindRequest  extends ApiRequest<DefectFindResponse> {

    public DefectFindRequest(){
        //super.apiCode="NA-B-2010-RE-00385";
        super.apiUrl="/jobmanage-center/defect/find/{professionalClass}";
        super.apiName="缺陷记录查询服务";
        super.apiDescribe="按照时间段、运行单位、检修单位、设备类型、缺陷分类、缺陷性质、处理流程、是否超期、电站名、是否处理；设备相关条件包括：设备类型、设备名称、设备型号、生产厂家、投运日期、发现时间等参数进行查询";
    }

   String professionalClass;
   CommonData commonData;



}
