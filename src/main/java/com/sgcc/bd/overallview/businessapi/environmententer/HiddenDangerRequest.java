package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiRequest;
import com.sgcc.bd.overallview.businessapi.Attachment;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/8/26 11:05
 * @File: HiddenDangerRequest
 */
@Data
public class HiddenDangerRequest extends ApiRequest<HiddenDangerResponse> {

    public HiddenDangerRequest(){

        //super.apiCode="NA-B-2010-RE-00385";
        super.apiUrl="/WMCenter/hazard/listHazard";
        super.apiName="隐患查询";
        super.apiDescribe="提供查询隐患列表服务能力";

    }

    Params params;
    String professionalClass;

    @Data
    public static class Params{
        String objId;
        String hazardNumber;
        String kind;
        String container;
        String stationLine;
        String voltage;
        String psr;
        String ast;
        String deviceName;
        String equipType;
        String equipMode;
        Date commissioningDate;
        String manufacturer;
        String hazardType;
        String discover;
        String diccovererName;
        String discoveryTeam;
        String discoveryGroupName;
        String discoveryOrg;
        String discoveryOrgName;
        String discoveryTime;
        String hazardLevel;
        String hazardReason;
        String hazardCategorize;
        String specialtyDetailAssort;
        String planTakeMeasures;
        String hazardDescription;
        String possibleConsequences;
        String takeMeasuresOrNot;
        String remark;
        String hazardStatus;
        String prciId;
        String cityOrg;
        String cityOrgName;
        String maintGroup;
        String maintGroupName;
        String maintainer;
        String maintOrgName;
        String recorder;
        String createUserName;
        String createGroup;
        String createGroupName;
        String createtOrg;
        String createOrgName;
        Date recordTime;
        String checkManId;
        String CheckOrgName;
        Date CheckTime;
        String appcreate;
        List<Attachment> attachments;
        String location;
        String longitude;
        String latitude;
        String hazardTitle;
        Date planedProcDate;
        String bay;
        String bayName;
        String area;
        String dangerLevel;
        String dangerLoc;
        String dangerousPointType;
        String dangerType;
        String dangerViolatioNotice;
        String defectRecordId;
        String equipmentOwnerId;
        String equipmentOwnerTel;
        String fireHazards;
        String isCheck;
        String isCritical;
        String isFalsePositive;
        String preAssessmentLevel;
        String professionalClass;
        String extend;
        String dataSource;
        String systemSourceId;
        List<HazardHandle> HazardHandle;
    }

    @Data
    public static class HazardHandle{
        String objId;
        String hazardId;
        String constructionUnitContacts;
        String constructionUnitTel;
        String contacts;
        String dangereLiminator;
        String contactInformation;
        String dangerViolatioNotice;
        String descriptionConditionsDangerousPoints;
        Date disposalEndTime;
        Date disposalStartTime;
        String distributionOrNotNotice;
        String endTimeGarrison;
        String feedBack;
        String fireHazards;
        String garrisonPersonnel;
        String isGarrison;
        Date measursDesbeforeRemediation;
        String ownerOrConstructionUnit;
        Date noticeDistributionTime;
        String patrolCycle;
        String reviewSpecialConstructionScheme;
        String securityAgreementSigner;
        String securityProtocolSn;
        Date signingDateSecurityAgreement;
        String signingSafetyAgreement;
        String signOrNotSafetyAgreement;
        Date startTimeGarrison;
        String uploadNotification;
        String warningBoardSetting;
        String actualDisposeDate;
        String actualTakeMeasures;
        String hsd;
        String legacy;
        String extend;
        String workLeader;
        String workLeaderName;
        Date workLeaderSignatureDate;
        Date acceptanceDate;
        String acceptanceOpinion;
        String acceptanceConclusion;
        String remark;
        String createUserId;
        String createUserName;
        String acceptanceUnitId;
        String acceptanceUnit;
        String acceptanceTeamid;
        String acceptanceTeam;
        String applicationOrg;
        String applicationOrgName;
    }



}
