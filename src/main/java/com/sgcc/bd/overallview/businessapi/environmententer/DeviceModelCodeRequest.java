package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiRequest;
import lombok.Data;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/8/25 15:10
 * @File: DeviceModelCodeRequest
 */
@Data
public class DeviceModelCodeRequest extends ApiRequest<DeviceModelCodeResponse> {

    public DeviceModelCodeRequest(){
        //super.apiCode="NA-B-2010-RE-00385";
        super.apiUrl="/psr-criterion-manage/equipType/getEquipByType";
        super.apiName="设备型号编码精确查询";
        super.apiDescribe="按设备型号编码精确查询设备信息";
    }

    String model;

    String psrType;

}
