package com.sgcc.bd.overallview.businessapi;

import com.sgcc.bd.overallview.businessapi.environmententer.JobOpTicketRequest;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/8/20 10:23
 * @File: CommonData
 */
@Data
public class CommonData {

    public Integer current;

    public String fields;

    public CommonData.RequestData filters;

    public String orderBy;

    public Integer page;

    public Integer perpage;

    public Integer size;


    @Data
    public static class RequestData{

        private String compare;

        private String fieldName;

        private String fieldValue;
    }
}
