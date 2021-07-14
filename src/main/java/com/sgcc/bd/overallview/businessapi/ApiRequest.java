package com.sgcc.bd.overallview.businessapi;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.lang.reflect.ParameterizedType;

@Data
@ApiModel(value="业务中台请求体基对象")
public class  ApiRequest<T extends ApiResponse> {

    @ApiModelProperty(value = "请求方式:post,get")
    protected String method="post";
    @ApiModelProperty(value = "接口 URL")
    protected String apiUrl;
    @ApiModelProperty(value = "服务编码")
    protected Object apiCode;
    @ApiModelProperty(value = "接口名称")
    protected Object apiName;
    @ApiModelProperty(value = "接口描述")
    protected Object apiDescribe;

    public Class<T> responseClass()
    {
        Class<T> tClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return tClass;
    }

}
