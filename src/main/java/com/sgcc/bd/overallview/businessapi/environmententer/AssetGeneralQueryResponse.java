package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/8/25 16:14
 * @File: AssetGeneralQueryResponse
 */
@Data
public class AssetGeneralQueryResponse extends ApiResponse {

    @ApiModelProperty(value = "响应数据")
    private InspectionReportMaintenanceResponse.InspectionReportMaintenanceData result;

    @Data
    public static class AssetGeneralQueryData{
        Integer total;
        Integer size;
        Integer current;
        Integer pages;
        Boolean searchCount;
        List<RecordData> records;
    }

    @Data
    public static class RecordData{
      String astId;
      String astNature;
      String astOrg;
      Date ctime;
      String deployState;
      String equipCode;
      Date lastUpdateTime;
      String projectName;
      String projectNum;
      String source;
    }
}
