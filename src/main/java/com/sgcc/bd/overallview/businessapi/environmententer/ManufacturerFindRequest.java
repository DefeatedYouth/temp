package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiRequest;
import lombok.Data;

/**
 * @description: TODO 设备型号编码
 * @author： hfl
 * @date：2021/8/25 14:57
 * @File: ManufacturerFindRequest
 */
@Data
public class ManufacturerFindRequest extends ApiRequest<ManufacturerFindResponse> {

    public ManufacturerFindRequest(){
        //super.apiCode="NA-B-2010-RE-00385";
        super.apiUrl="/psr-criterion-manage/equipProd/getEquipByCode";
        super.apiName="生产厂家精确查询";
        super.apiDescribe="按生产厂家编码精确查询生产厂家名称";
    }

    String manufacturerNum;

}
