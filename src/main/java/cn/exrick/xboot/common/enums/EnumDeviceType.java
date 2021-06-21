package cn.exrick.xboot.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 缺陷状态 0正常 1：一般 2：严重，3：危急
 * @author： hfl
 * @date：2020/9/30 17:29
 * @File: EnumDefectStatus
 */
public enum EnumDeviceType {
    //
    OilImmersedTransformer(1, "油浸式变压器"),
    Breaker(2, "断路器"),
    CombinationAppliances(3, "组合电器"),
    Displacement(4, "隔离开关"),
    IsolatingSwitch(5, "开关柜"),
    CurrentTransformer(6, "电流互感器"),
    VoltageTransformer(7, "电压互感器"),
    LightningArrester(8, "避雷器"),
    ParallelCapacitorBank(9, "并联电容器组"),
    DryReactor(10, "干式电抗器"),
    SeriesCompensationDevice(11, "串联补偿装置"),
    BusbarInsulator(12, "母线及绝缘子"),
    WallBushing(13, "穿墙套管"),
    PetersenCoil(14, "消弧线圈"),
    HighFrequencyWaveTrap(15, "高频阻波器"),
    CouplingCapacitor(16, "耦合电容器"),
    HighColtageFuse(17, "高压熔断器"),
    NeutralPointBlockingDevice(18, "中性点隔直装置"),
    GroundingDevice(19, "接地装置"),
    TerminalBoxAndMaintenancePowerBox(20, "端子箱及检修电源箱"),
    StationChange(21, "站用变"),
    StationACPowerSystem(22, "站用交流电源系统"),
    StationDCPowerSystem(23, "站用直流电源系统"),
    StructuralScaffold(24, "构支架"),
    AuxiliaryFacilities(25, "辅助设施"),
    CivilEngineeringFacilities(26, "土建设施"),
    lightningRod(27, "避雷针"),
    LightningArresterActionFrequencyTable(28, "避雷器动作次数表"),
    HighResistance(29, "高抗"),
    SecondaryScreenCabinet(30, "二次屏柜"),
    FireFightingSystem(31, "消防系统"),
    PowerCable(32, "电力电缆"),
    OutletSleeve(33, "出线套管"),
    Reactor(34, "电抗器"),
    Capacitor(35, "电容器"),
    CapacitorTower(36, "电容器塔"),
    Resistor(37, "电阻器"),
    ValveTower(38, "阀塔"),
    CommutationTransformer(39, "换流变"),
    GroundingSwitch(40, "接地刀闸"),
    InletSleeve(41, "进线套管"),
    Busbar(42, "母线"),
    SmoothingReactor(43, "平波电抗器"),
    Boost(44, "升压变"),
    LeadAirChamber(45, "引线气室"),
    LeadVoltageChange(46, "引线压变"),
    DCDivider(47, "直流分压器");
    private Integer value;
    private String text;

    private static Map<Integer, EnumDeviceType> pool = new HashMap<Integer, EnumDeviceType>();

    static {
        for (EnumDeviceType each : EnumDeviceType.values()) {
            EnumDeviceType defined = pool.get(each.getValue());
            if (null != defined) {
                pool.put(null, null);
            }
            pool.put(each.getValue(), each);
        }
    }


    EnumDeviceType(Integer code, String message) {
        this.value = code;
        this.text = message;
    }


    public static EnumDeviceType valueOf(Integer code) {
        return pool.get(code);
    }

    public Integer getValue() {
        return this.value;
    }

    public String getText() {
        return text;
    }
}
