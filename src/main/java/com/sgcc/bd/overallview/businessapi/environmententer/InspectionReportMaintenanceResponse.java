package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/8/20 16:11
 * @File: InspectionReportMaintenanceResponse
 */
@Data
public class InspectionReportMaintenanceResponse  extends ApiResponse {

    @ApiModelProperty(value = "响应数据")
    private InspectionReportMaintenanceData result;

    @Data
    public  static class  InspectionReportMaintenanceData{

        Integer current;

        List orders;

        Integer pages;

        List<LiveWorkingsChemeRegistrationVo> records;

        Boolean searchCount;

        Integer size;

        Integer total;

    }

    @Data
    public  static class  LiveWorkingsChemeRegistrationVo{

        String mRID;

        String professionalClass;

        Date startTime;

        Date endTime;

        String stationLineInfomation;

        String substation;

        String unit;

        String voltageLevel;

        String workDirector;

        String workPlace;

        String workPlan;

    }
}
