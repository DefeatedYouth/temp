package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.poi.ss.formula.functions.T;

import java.util.Date;
import java.util.List;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/8/26 11:05
 * @File: HiddenDangerResponse
 */
@Data
public class HiddenDangerResponse extends ApiResponse {

    @ApiModelProperty(value = "响应数据")
    private List<HiddenDangerRequest.Params> result;


/*    @Data
    public static class Defect{
        String objId;
        String professionalClass;
        String discoveryGroup;
        String discoveryGroupName;
        String discoverer;
        String discovererName;
        String discoveryOrg;
        String quotMonadName;
        Date discoveredDate;
        String kind;
        String containerName;
        String container;
        String equipType;
        String equipmentTypeName;
        String euqipName;
        String equipmentId;
        String astId;
        String voltage;
        String manufacturer;
        String equipSpeciesCode;
        String equipSpeciesName;
        String componentType;
        String componentTypeName;
        String componentSpecies;
        String componentSpeciesName;
        String defectLocation;
        String defectZone;
        String defectDesc;
        String defectDescName;
        String sortRef;
        String classificationName;
        String whetherCorrective;
        String eliminateByOneseOrNot;
        String defectContent;
        String defectProperties;
        String remarks;
        List<T> defectAttachment;
        String state;
        String prciId;
        String cityOrg;
        String cityOrgName;
        String maintGroup;
        String correctiveTeamName;
        String maintOrg;
        String correctiveMonadName;
        String updateUserId;
        String updateUserName;
        String createUserId;
        String createUserName;
        String dataSource;
        String dataSourceId;
        String systemSourceId;
        String findMethod;
        String solveMaintOrg;
        String solveMaintOrgName;
        String solveGroup;
        String solveGroupName;
        List<SolveUser> solveUsers;
        Date solveTime;
        String technicalReasons;
        String liabilityCause;
        String remainingProblems;
        String delayState;
        String delayReasons;
        String acceptor;
        String acceptorName;
        String acceptancePassOrNot;
        String acceptanceGroup;
        String acceptanceGroupName;
        String acceptanceOrg;
        String acceptanceOrgName;
        String acceptanceReportSs;
        String acceptanceReportMs;
        String acceptanceOpinion;
        Date acceptanceDate;
    }

    @Data
   public static class SolveUser{

       String objId;

       String user;

       String userName;

       String cityOrg;

       String cityOrgName;

       String maintGroup;

       String maintGroupName;

   }*/

}
