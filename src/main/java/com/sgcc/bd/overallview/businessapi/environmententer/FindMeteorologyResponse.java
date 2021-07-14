package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiResponse;
import com.sgcc.bd.overallview.businessapi.oauth.GetBusinessApplicationResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@ApiModel(value="查询天气Response")
public class FindMeteorologyResponse extends ApiResponse {


    @ApiModelProperty(value = "响应数据")
    private ResponseData result;

    @Data
    @ApiModel(value="查询天气ResponseData")
    public static class ResponseData{

        @ApiModelProperty(value = "环境温度")
        private String ambientTemperature;

        @ApiModelProperty(value = "所属城市")
        private String city;

        @ApiModelProperty(value = "时间")
        private Date ctime;

        @ApiModelProperty(value = "主键id")
        private String objId;

        @ApiModelProperty(value = "所属网省")
        private String province;

        @ApiModelProperty(value = "光照强度")
        private String sunshineIntensity;

        @ApiModelProperty(value = "风速")
        private String windSpeed;
    }
}
