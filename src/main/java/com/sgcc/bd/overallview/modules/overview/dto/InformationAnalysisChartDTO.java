package com.sgcc.bd.overallview.modules.overview.dto;

import com.sgcc.bd.overallview.modules.shebei.entity.SbFuhe;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/7/15 15:17
 * @File: InformationAnalysisChartDTO
 */
@Data
public class InformationAnalysisChartDTO {

  private   List<SbFuhe> sbFuhes;

  private  String values;

  private  Date date;
}
