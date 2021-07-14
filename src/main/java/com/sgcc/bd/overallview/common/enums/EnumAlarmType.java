package com.sgcc.bd.overallview.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 缺陷状态 0正常 1：一般 2：严重，3：危急
 * @author： hfl
 * @date：2020/9/30 17:29
 * @File: EnumDefectStatus
 */
public enum EnumAlarmType {
    //
    Nomal(0,"正常"),
    Accident(1, "事故"),
    Abnormal(2, "异常"),
    CrossLine(3, "越线"),
    Displacement(4, "变位"),
    Inform(5, "告知");
    private Integer value;
    private String text;

    private static Map<Integer, EnumAlarmType> pool = new HashMap<Integer, EnumAlarmType>();

    static {
        for (EnumAlarmType each : EnumAlarmType.values()) {
            EnumAlarmType defined = pool.get(each.getValue());
            if (null != defined) {
                pool.put(null, null);
            }
            pool.put(each.getValue(), each);
        }
    }


    EnumAlarmType(Integer code, String message) {
        this.value = code;
        this.text = message;
    }


    public static EnumAlarmType valueOf(Integer code) {
        return pool.get(code);
    }

    public Integer getValue() {
        return this.value;
    }

    public String getText() {
        return text;
    }
}
