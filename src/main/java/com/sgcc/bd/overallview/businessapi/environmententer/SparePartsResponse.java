package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiResponse;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/8/20 14:49
 * @File: SparePartsResponse
 */
@Data
public class SparePartsResponse extends ApiResponse {

    private List<SparePartsResponseData> result;

    @Data
    public  static class  SparePartsResponseData{

        private String mRID;

        private String name;

        private String parentID;

        private String sort;

        private String creator;

        private String modifier;

        private Date createTime;

        private Date updateTime;
    }
}
