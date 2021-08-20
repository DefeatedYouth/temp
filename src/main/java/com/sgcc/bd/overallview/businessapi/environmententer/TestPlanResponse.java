package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiResponse;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/8/20 15:14
 * @File: TestPlanResponse
 */
@Data
public class TestPlanResponse extends ApiResponse {


    private TestPlanResponseData result;

    @Data
    public  static class  TestPlanResponseData{

        Integer current;

        List orders;

        Integer pages;

        List<Records> records;

        Boolean searchCount;

        Integer size;

        Integer total;

    }

    @Data
    public  static class  Records{

        String mRID;

        String testClassification;

        String substationName;

        String substationlevel;

        String detectionLineName;

        String voltageLevelName;

        String detectionType;

        String equipmentName;

        String bayName;

        String startPoleNo;

        String endPoleNo;

        String erectionMethod;

        String equipmentType;

        java.util.Date startDate;

        Date planCompletionDate;

        Date lastInspectionTime;

        Integer cycle;

        String cycleUnit;

        Integer warningDays;

        Integer overdueDays;

        String operationUnitName;

        String maintenanceTeamName;

        String planState;

        Date releaseTime;

        Date prepareDate;

        Boolean weatherOutsourcing;

        String detectionUnitName;

        String outsourcingUnitPrincipal;

        Boolean weatherOutageremark;

        String remark;

        String professionalClass;

    }

}
