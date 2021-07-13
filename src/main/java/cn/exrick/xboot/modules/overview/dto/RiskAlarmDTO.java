package cn.exrick.xboot.modules.overview.dto;

import cn.exrick.xboot.modules.base.entity.BaseInspectionRisk;
import cn.exrick.xboot.modules.base.entity.BaseMeteorologicalWarning;
import cn.exrick.xboot.modules.base.entity.BasePowerProtection;
import cn.exrick.xboot.modules.base.entity.BaseRiskWarning;
import lombok.Data;

import java.util.List;

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
