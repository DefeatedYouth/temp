package com.sgcc.bd.overallview.businessapi.environmententer;
import com.sgcc.bd.overallview.businessapi.ApiRequest;
import com.sgcc.bd.overallview.businessapi.Attachment;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/8/26 15:29
 * @File: RepairTestRecordRequest
 */
@Data
public class RepairTestRecordRequest extends ApiRequest<RepairTestRecordResponse> {

    public RepairTestRecordRequest(){

        //super.apiCode="NA-B-2010-RE-00385";
        super.apiUrl="/WMCenter/examineRepair/findRepairTest";
        super.apiName="修试记录查询";
        super.apiDescribe="提供查询修试记录列表服务能力";

    }

    String professionalClass;

    RequestSearchParams params;

    @Data
    public static class RequestSearchParams{
        String objId;
        String equipName;
        String equipType;
        String ticketNo;
        String ticket;
        String psrId;
        String astId;
        Date workDate;
        String workContent;
        String isQualified;
        String finishCondition;
        String leftProblem;
        String workGroupName;
        String workGroup;
        String cityOrg;
        String professionalClass;
        String cityOrgName;
        String maintGroup;
        String maintGroupName;
        String maintOrg;
        String maintOrgName;
        String createUserId;
        String createUserName;
        Date createTime;
        String updateUserId;
        String updateUserName;
        Date editTime;
        String remark;
        String extend;
        String equipLocationId;
        String deviceType;
        String bay;
        String bayName;
        String workTeamID;
        String workTeam;
        String workType;
        List<User> workingPerson;
        String taskID;
        String workTicketNo;
        String workTicketID;
        String professionNature;
        String maintenanceTypeCode;
        String completionStatus;
        String legacy;
        String registrationWay;
        String recordingStatus;
        String isOutCode;
        String outssourcingUnit;
        String dispatchingSituation;
        String monitor;
        String acceptorID;
        String acceptor;
        String acceptanceOpinion;
        Date date;
        String defectStatsCode;
        String jobDescription;
        String workScheme;
        String workPlan;
        String eligibility;
        String workLeaderId;
        String workLeader;
        String powerCutArea;
        String stationLineName;
        String stationLineId;
        String stationLineType;
        List<DefectOrHazard> defectOrHazard;
        String PROCESS_TASK_ID;
        String actStartTime;
        String actEndTime;
        String state;
        List<Attachment> attachment;
    }

    @Data
    public static class User{
        String user;
        String userName;
        String group;
        String groupName;
        String extend;
    }


    @Data
    public static class DefectOrHazard{
        String objId;
        String type;
        String extend;
    }

}
