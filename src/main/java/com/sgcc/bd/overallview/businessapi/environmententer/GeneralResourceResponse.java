package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/8/20 11:13
 * @File: GeneralResourceResponse
 */
@Data
public class GeneralResourceResponse extends ApiResponse {

    @ApiModelProperty(value = "响应数据")
    private GeneralResourceResponse.ResponseData result;

    @Data
    public static class ResponseData{

        private Record records;

        private Integer   total;

        private Integer   size;

        private Integer   current;

        private Integer   pages;

        private String    orders;

        private boolean searchCount;

    }

    @Data
    public static class Record{

        String maintOrg;

        String stationType;

        String supplyArea;

        Double buildingArea;

        String dispatchMonitor;

        String fireAcceptance;

        String type;

        String arrangement;

        Integer coverArea;

        String isRural;

        Date ctime;

        String geoPositon;

        String stationCapacity;

        String equipmentOwner;

        String psrId;

        String telephone;

        String ratedDcTransmissionCapacity;

        String dispatchJurisdiction;

        String astId;

        String isSmartStation;

        String isLoadStation;

        String dispatchName;

        String name;

        String isAvc;

        String isGis;

        String converterStationType;

        Date lastUpdateTime;

        String dispatchPermission;

        Integer altitude;

        String psrState;

        String regionalism;

        String city;

        String importance;

        String isCentralMonitor;

        String dispatchOperation;

        String highestDispatchJurisdiction;

        String runDevName;

        Date startTime;

        Date stopTime;

        String transformerQuantity;

        String address;

        String maintGroup;

        String importantLevel;

        String contaminationLevel;

        String dcSystem;

        String voltageLevel;

        String isFirts;

        String fireType;

        String dutyMode;

        String isJunctionStation;

        String isN1;
    }

}
