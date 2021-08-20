package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiRequest;
import com.sgcc.bd.overallview.businessapi.CommonData;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/8/20 10:56
 * @File: GeneralResourceRequest
 */
@Data
@ApiModel(value="变电专业资源通用查询服务")
public class GeneralResourceRequest extends ApiRequest<FindDeviceByIdResponse> {

    public GeneralResourceRequest(){
        //super.apiCode="NA-B-2010-RE-00385";
        super.apiUrl="/psr-center/psrTFService/commonQuery";
        super.apiName="变电专业资源通用查询服务";
        super.apiDescribe="通过单位、电压等级、投运时间、生产厂家等通用条件查询一类或多类变电设备信息";
    }

    private String id;

    private String psrType;

    private String modelId;

    private Integer distribution;

    private CommonData commonData;
}
