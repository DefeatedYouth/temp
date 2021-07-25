package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

import java.util.List;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/7/25 14:51
 * @File: JobOpTicketResponse
 */
@Data
@ApiModel(value="查询操作票Response")
public class JobOpTicketResponse extends ApiResponse {

    @ApiModelProperty(value = "响应数据")
    private ResponseData result;

    @Data
    @ApiModel(value="查询操作票ResponseData")
    public static class ResponseData{

        private Integer current;

        private List orders;

        private  Integer pages;

        private List records;

        private Boolean searchCount;

        private Integer size;

        private Integer total;
    }
}
