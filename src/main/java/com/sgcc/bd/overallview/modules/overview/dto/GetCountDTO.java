package com.sgcc.bd.overallview.modules.overview.dto;

import com.sgcc.bd.overallview.modules.shebei.dto.SbDefectDTO;
import lombok.Data;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/7/15 16:35
 * @File: getCountDTO
 */
@Data
public class GetCountDTO {

   private SbDefectDTO countDefectNum ;
   private SbDefectDTO countDangerNum;
}
