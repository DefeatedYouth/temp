package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/8/20 10:41
 * @File: FindDeviceByIdResponse
 */
public class FindDeviceByIdResponse extends ApiResponse {

    @ApiModelProperty(value = "响应数据")
    private List<ResponseData> result;

    @Data
    public static class ResponseData{

        private String psrId;

        private String astId;

        private String name;

        private String runDevName;

        private String city;

        private String maintOrg;

        private String maintGroup;

        private String equipmentOwner;

        private String voltageLevel;

        private String psrState;

        private Date startTime;

        private Date stopTime;

        private String transformerType;

        private String transformer;

        private String erectionMethod;

        private String isRural;

        private Integer length;

        private Integer overheadLength;

        private Integer cableLength;

        private Date ctime;

        private String zone;

        private Date lastUpdateTime;

        private String startType;

        private String startPosition;

        private String startSwitch;

    }
}
