package com.sgcc.bd.overallview.businessapi.environmententer;

import com.alibaba.fastjson.annotation.JSONField;
import com.sgcc.bd.overallview.businessapi.ApiRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value="查询天气Request")
public class FindMeteorologyRequest extends ApiRequest<FindMeteorologyResponse> {

    public FindMeteorologyRequest(){
        super.apiCode="NA-B-2010-RE-00385";
        super.apiUrl="/environment-center/meteorologyService/findMeteorology";
        super.apiName="查询天气";
        super.apiDescribe="根据所属地市与时间查询天气信息";
    }

    @ApiModelProperty(value = "所属地市")
    public String city;

    @ApiModelProperty(value = "时间")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    public Date time;
}
