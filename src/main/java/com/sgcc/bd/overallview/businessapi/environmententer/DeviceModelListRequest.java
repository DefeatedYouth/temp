package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiRequest;
import lombok.Data;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/8/25 15:31
 * @File: DeviceModelListRequest
 */
@Data
public class DeviceModelListRequest extends ApiRequest<DeviceModelListResponse> {

    public DeviceModelListRequest(){
        //super.apiCode="NA-B-2010-RE-00385";
        super.apiUrl="/psr-criterion-manage/equipType/getEquipTypeList";
        super.apiName="设备型号列表查询";
        super.apiDescribe="根据生产厂家，设备型号模糊查找设备型号列表。";
    }

    Integer size;

    Integer current;

    String manufacturerNum;

    String searchValue;

    String psrType;

}
