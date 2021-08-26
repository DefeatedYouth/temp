package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


/**
 * @description: TODO
 * @author： hfl
 * @date：2021/8/25 10:28
 * @File: ToolsEquipmentLedgerResponse
 */
@Data
public class ToolsEquipmentLedgerResponse extends ApiResponse {

    @ApiModelProperty(value = "响应数据")
    private ToolsEquipmentLedgerData result;

    @Data
    public  static class  ToolsEquipmentLedgerData{

        String astId;

        String astNature;

        String astNum;

        String astOrg;

        String astOrgName;

        String attachment;

        String city;

        Date ctime;

        String deployState;

        String equipCode;

        String equipType;

        String extendDesc;

        String flowCode;

        Date lastUpdateTime;

        String maintOrg;

        String manufactureNum;

        String manufacturer;

        String model;

        String name;

        String operateDate;

        String professionalType;

        String projectName;

        String projectNum;

        String remark;

        String runDevName;

        String source;

        String storageOrg;

        String techSpecification;

        String usedMonth;

        String utcNum;

        String wbsNum;
    }


}
