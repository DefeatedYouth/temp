package com.sgcc.bd.overallview.common.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/6/17 17:26
 * @File: municipalCompanyVO
 */
@Data
public class MunicipalCompanyVO extends BaseReqVO{

    @ApiModelProperty(value = "层级 1 地市公司 2 工区 3 班组")
    private Integer level;

    @ApiModelProperty(value = "父级id")
    private Long parentId;

    @ApiModelProperty(value = "电压等级")
    private String voltageLevel;
}
