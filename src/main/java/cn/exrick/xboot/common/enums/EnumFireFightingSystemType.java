package cn.exrick.xboot.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 缺陷状态 0正常 1：一般 2：严重，3：危急
 * @author： hfl
 * @date：2020/9/30 17:29
 * @File: EnumDefectStatusu
 */
public enum EnumFireFightingSystemType {
    //
    WaterSprayFireExtinguishingSystem(1,"水喷雾灭火系统"),
    WaterMistSystem(2,"细水雾灭火系统"),
    FoamSprayFireExtinguishingSystem(3,"泡沫喷雾灭火系统"),
    OilDrainageAndNitrogenInjectionFireRxtinguishingSystem(4, "排油注氮灭火系统");

    private Integer value;
    private String text;

    private static Map<Integer, EnumFireFightingSystemType> pool = new HashMap<Integer, EnumFireFightingSystemType>();

    static {
        for (EnumFireFightingSystemType each : EnumFireFightingSystemType.values()) {
            EnumFireFightingSystemType defined = pool.get(each.getValue());
            if (null != defined) {
                pool.put(null, null);
            }
            pool.put(each.getValue(), each);
        }
    }


    EnumFireFightingSystemType(Integer code, String message) {
        this.value = code;
        this.text = message;
    }


    public static EnumFireFightingSystemType valueOf(Integer code) {
        return pool.get(code);
    }

    public Integer getValue() {
        return this.value;
    }

    public String getText() {
        return text;
    }
}
