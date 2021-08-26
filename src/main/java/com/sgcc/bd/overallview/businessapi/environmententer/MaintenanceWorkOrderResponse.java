package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @description: TODO 修试记录查询
 * @author： hfl
 * @date：2021/8/26 15:15
 * @File: MaintenanceWorkOrderResponse
 */
public class MaintenanceWorkOrderResponse  extends ApiResponse {


    @ApiModelProperty(value = "响应数据")
    private List<RepairWorkOrder> result;

    @Data
    public static class RepairWorkOrder{
        String objId;
        String workOrderNo;
        String workContent;
        String stationLine;
        String stationLineName;
        Date planStartTime;
        Date StartTime;
        Date Datetime;
        String arranger;
        String arrangerName;
        String controllerName;
        String controller;
        List<workUser> workUsers;
        String state;
        String workGroupName;
        String workGroup;
        String professionalClass;
        String cityOrg;
        String cityOrgName;
        String deleteState;
        String createUserId;
        String createUserName;
        Date createTime;
        String updateUserId;
        String updateUserName;
        Date editTime;
        String remark;
        String editDept;
        String editDeptname;
        String controllerOrgName;
        String controllerOrg;
        String constructOrg;
        String constructContact;
        String isOutsourcing;
        String constructPhone;
        String repairEquipType;
        String repairEquipPsr;
        String repairEquipName;
        String containerType;
        String extend;
        List<relation> relations;
    }

    @Data
    public static class relation{

        String objID;

        String repairWorkOrderID;

        String relationObj;

        String relationObjType;

    }

    @Data
    public static class workUser{

        String objID;

        String repairWorkOrder;

        String personnel;

        String personnelName;

        String group;

        String departmentName;

    }



}
