package com.sgcc.bd.overallview.modules.overview.dto;

import com.sgcc.bd.overallview.modules.base.entity.BaseInspectionRisk;
import com.sgcc.bd.overallview.modules.base.entity.BaseMeteorologicalWarning;
import com.sgcc.bd.overallview.modules.base.entity.BasePowerProtection;
import com.sgcc.bd.overallview.modules.base.entity.BaseRiskWarning;
import lombok.Data;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/7/12 9:25
 * @File: RiskAlarmDTO
 */
@Data
public class RiskAlarmDTO {

    private BaseMeteorologicalWarning baseMeteorologicalWarning;

    private BasePowerProtection basePowerProtection;

    private BaseInspectionRisk baseInspectionRisk;

    private BaseRiskWarning baseRiskWarning;

}
