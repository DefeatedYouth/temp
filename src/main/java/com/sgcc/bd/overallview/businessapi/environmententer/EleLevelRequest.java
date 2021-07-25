package com.sgcc.bd.overallview.businessapi.environmententer;

import com.alibaba.fastjson.annotation.JSONField;
import com.sgcc.bd.overallview.businessapi.ApiRequest;
import com.sgcc.bd.overallview.businessapi.ApiResponse;
import com.sgcc.bd.overallview.businessapi.environmententer.FindMeteorologyResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.lang.reflect.ParameterizedType;
import java.util.Date;

@Data
@ApiModel(value="查询天气Request")
public class EleLevelRequest extends ApiRequest<EleLevelResponse> {

    public EleLevelRequest(){
        //super.apiCode="NA-B-2010-RE-00385";
        super.apiUrl="/psr-criterion-manage/commonCode/getCommonCodeByTypeCode";
        super.apiName="查询电压等级";
        super.apiDescribe="根据类型码查询电压等级信息";
    }

    @ApiModelProperty(value = "类型码")
    public String typeCode;

}

