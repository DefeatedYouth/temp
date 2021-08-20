package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiRequest;
import com.sgcc.bd.overallview.businessapi.CommonData;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/8/20 9:45
 * @File: FindDeviceByIdRequest
 */
@Data
@ApiModel(value="通过ID获取设备request")
public class FindDeviceByIdRequest extends ApiRequest<FindDeviceByIdResponse> {

    public FindDeviceByIdRequest(){
        //super.apiCode="NA-B-2010-RE-00385";
        super.apiUrl="/psr-center/psrQueryServices/psrLvLine/byID";
        super.apiName="通过ID获取设备";
        super.apiDescribe="/psr-center/psrQueryServices/{psrTypeName}/byID    需要查询的资源类型名称，参见：2.6资源资产类型表 在这里使用实例值psrLvLine";
    }

    public CommonData commonData;

    public  String psrTypeName;

    public String dataType;

    public String startClassName;

    public String startID;

    public String psrType;

}
