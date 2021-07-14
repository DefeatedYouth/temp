package com.sgcc.bd.overallview.modules.overview.dto;

import lombok.Data;

import java.util.List;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/7/11 14:07
 * @File: AlarmDTO
 */
@Data
public class AlarmDTO {

    private List  onlineAlarmList;

    private Integer onlineAlarmNum;

    private List  monitoringAlarmList;

    private Integer monitoringAlarmNum;

    private List activeWarning;

    private Integer activeWarningNum;
}
