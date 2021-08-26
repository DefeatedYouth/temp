package com.sgcc.bd.overallview.businessapi.environmententer;

import cn.hutool.core.date.DateTime;
import com.sgcc.bd.overallview.businessapi.ApiRequest;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/8/26 10:39
 * @File: InspectionPlanRequest
 */
@Data
public class InspectionPlanRequest extends ApiRequest<InspectionPlanResponse> {

    public InspectionPlanRequest(){
        //super.apiCode="NA-B-2010-RE-00385";
        super.apiUrl="/WMCenter/inspectionPlan/inspectionPlanList";
        super.apiName="检测计划查询";
        super.apiDescribe="提供查询检测计划列表服务能力";
    }

    String professionalClass;
    InspectionPlan inspectionDemand;

    @Data
    public static class InspectionPlan{
        String objId;
        DateTime startDate;
        DateTime endDate;
        String professionalClass;
        String stationLineId;
        String stationLineName;
        String stationLineType;
        String testClassification;
        List<inspectionRange> inspectionRange;
        String inspectionContext;
        String state;
        String cityOrg;
        String cityOrgName;
        String maintGroup;
        String maintenanceTeamName;
        String maintOrg;
        String operationUnitName;
        String updateUserId;
        String updateUserName;
        Date updateTime;
        String createUserId;
        String createUserName;
        Date prepareDate;
        String extend;
        String inspectionDept;
        String inspectionDeptName;
        String inspectionCrewId;
        String detectionUnitName;
        String inspectionRangeLineLe;
        String inspectionCableLevel;
        List<InspectionStaff> inspectionStaffs;
        String weather;
        String temperature;
        String humidity;
        String warningDays;
        String inspectionDemandType;
        String effectRange;
        String voltage;
        String rule;
        String dataSource;
        String dataSourcdId;
        String systemSourceId;
    }

    @Data
    public static class inspectionRange{

        String objId;

        String equipNo;

        String equipName;

        String equipType;

        String inspectionionItemType;

        String urbanRuralFlag;

        String psrId;

        String astId;

        String equipModel;

        String manufacturer;

        String extend;
    }

    @Data
    public static class InspectionStaff{

        String objId;

        String inspectionerId;

        String inspectionerName;

        String inspectionerType;

    }


}
