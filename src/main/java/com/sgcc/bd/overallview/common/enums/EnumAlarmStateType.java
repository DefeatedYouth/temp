package com.sgcc.bd.overallview.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 缺陷状态 0正常 1：一般 2：严重，3：危急
 * @author： hfl
 * @date：2020/9/30 17:29
 * @File: EnumDefectStatusu
 */
public enum EnumAlarmStateType {
    //asda
    Untreated(0,"未报警"),
    //asdasda
    Processed(1, "已报警");
    private Integer value;
    private String text;

    private static Map<Integer, EnumAlarmStateType> pool = new HashMap<Integer, EnumAlarmStateType>();

    static {
        for (EnumAlarmStateType each : EnumAlarmStateType.values()) {
            EnumAlarmStateType defined = pool.get(each.getValue());
            if (null != defined) {
                pool.put(null, null);
            }
            pool.put(each.getValue(), each);
        }
    }


    EnumAlarmStateType(Integer code, String message) {
        this.value = code;
        this.text = message;
    }


    public static EnumAlarmStateType valueOf(Integer code) {
        return pool.get(code);
    }

    public Integer getValue() {
        return this.value;
    }

    public String getText() {
        return text;
    }
}
