package com.sgcc.bd.overallview.modules.overview.dto;

import lombok.Data;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/7/11 17:05
 * @File: TodayWorkDTO
 */
@Data
public class TodayWorkDTO {

    private List  operationList;

    private Integer operationNum;

    private List  overhaulList;

    private Integer overhaulNum;

    private List  lineMaintenanceList;

    private Integer lineMaintenanceNum;
}
