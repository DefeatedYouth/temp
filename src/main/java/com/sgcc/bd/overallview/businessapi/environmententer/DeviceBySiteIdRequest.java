package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiRequest;
import lombok.Data;

import java.util.List;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/8/25 17:13
 * @File: DeviceBySiteIdRequest
 */
@Data
public class DeviceBySiteIdRequest  extends ApiRequest<DeviceBySiteIdResponse> {

    public DeviceBySiteIdRequest(){
        //super.apiCode="NA-B-2010-RE-00385";
        super.apiUrl="/PSRCenter/psrTFService/queryByStationContainer";
        super.apiName="按照站房查询站房内设备信息";
        super.apiDescribe="按照指定站房ID、站房类型、所属设备类型查询站房内所属设备信息列表，支持多设备类型查询";
    }

    String psrId;

    List<String> psrTypeList;

    String stationType;

    String orderBy;

    Integer page;

    Integer perPage;

}
