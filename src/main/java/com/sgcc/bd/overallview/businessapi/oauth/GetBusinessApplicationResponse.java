package com.sgcc.bd.overallview.businessapi.oauth;

import com.sgcc.bd.overallview.businessapi.ApiResponse;
import com.sgcc.bd.overallview.businessapi.oauth.domainentity.BusinessApplication;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value="获取业务应用信息Response")
public class GetBusinessApplicationResponse extends ApiResponse {


    @ApiModelProperty(value = "响应数据")
    private List<BusinessApplication> result;

}
