package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@ApiModel(value="查询天气Response")
public class EleLevelResponse extends ApiResponse {


    @ApiModelProperty(value = "响应数据")
    private List<ResponseData> result;

    @Data
    @ApiModel(value="查询天气ResponseData")
    public static class ResponseData{

        @ApiModelProperty(value = "编号")
        private String code;

        @ApiModelProperty(value = "名称")
        private String name;
    }
}
