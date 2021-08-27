package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/8/27 17:29
 * @File: TransformerResponse
 */
@Data
public class TransformerResponse extends ApiResponse {


    @ApiModelProperty(value = "响应数据")
    private Map<String,TransformerData> result;

    @Data
    public static class  TransformerData{
        Integer current;
        String orders;
        Integer pages;
        List<Record> records;

        @Data
        public static class Record{
            Assects assects;
            String id;
            String modelId;
            ResourceData  resourceData;

            @Data
            public static class Assects{
                String manufacturer;
                String model;
                Date operateDate;
            }

            @Data
            public static class ResourceData{
                //资源id
                String psrId;
                String name;
                String city;
                String maintOrg;
                String maintGroup;
                String station;
                String voltageLevel;

            }
        }
    }









}
