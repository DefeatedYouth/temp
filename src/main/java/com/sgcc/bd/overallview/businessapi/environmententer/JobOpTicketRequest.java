package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/7/25 14:45
 * @File: JobOpTicketRequest
 */
@Data
@ApiModel(value="操作票查询Request")
public class JobOpTicketRequest extends ApiRequest<JobOpTicketResponse> {

    public JobOpTicketRequest(){
        //super.apiCode="NA-B-2010-RE-00385";
        super.apiUrl="/jobmanage-center/scheduledAcTicket/ticket/find";
        super.apiName="查询操作票信息";
        super.apiDescribe="提供操作票查询服务，如按电站/线路、票种类、操作人、操作时间、评价状态、评价结果等";
    }

    public Integer current;

    public String fields;

    public RequestData filters;

    public String orderBy;

    public Integer page;

    public Integer perpage;

    public Integer size;


    @Data
    @ApiModel(value="操作票RequestData")
    public static class RequestData{

        private String compare;

        private String fieldName;

        private String fieldValue;
    }
}
