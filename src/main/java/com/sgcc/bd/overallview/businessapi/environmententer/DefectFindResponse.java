package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @description: TODO 生产厂家
 * @author： hfl
 * @date：2021/8/25 14:33
 * @File: DefectFindResponse
 */
@Data
public class DefectFindResponse  extends ApiResponse {


    @ApiModelProperty(value = "响应数据")
    private DateResult result;


    @Data
    public  static class  DateResult{

        Integer current;

        java.util.List orders;

        Integer pages;

        DefectFindResponseDate records;

        boolean searchCount;

        Integer size;

        Integer total;

    }

    @Data
    public  static class  DefectFindResponseDate{
        String mRID;
        String professionalNature;
        String kind;
        String containerName;
        String stationName;
        String lineName;
        String equipmentId;
        String defectCode;
        String equipmentTypeName;
        String equipmentModel;
        String manufacturer;
        Date discoveredDate;
        String discovererName;
        String quotMonadName;
        String defectZone;
        String defectProperties;
        String classificationName;
        String defectContent;
        String remarks;
        String stationVoltage;
        String lineVoltage;
        String containerVoltage;
        String isFamilyDefect;
        String findSource;
        String acceptanceMonadName;
        String phase;
        String attachmentsNo;
        String pWFeederLineId;
        String defectState;
        String fileName;
        String whetherCorrective;
        String correctiveDate;
        String principal;
        String correctivePeasonName;
        String correctiveMonadName;
        String correctiveTeamName;
        String dutyReasons;
        String technicalReason;
        String disposeDetail;
        String legacy;
        String acceptanceOpinion;
        String whetherAcceptanceQual;
        String acceptorName;
        Date acceptanceTime;
        String professionalClass;
    }

}
