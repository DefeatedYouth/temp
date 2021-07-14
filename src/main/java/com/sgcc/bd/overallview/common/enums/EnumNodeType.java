package com.sgcc.bd.overallview.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/6/22 14:12
 * @File: EnumNodeType
 */
public enum EnumNodeType {
    //asda
    DeploymentStatus(0,"布防状态"),
    //asdasda
    TheStateOfWithdrawal(1, "撤防状态");
    private Integer value;
    private String text;

    private static Map<Integer, EnumNodeType> pool = new HashMap<Integer, EnumNodeType>();

    static {
        for (EnumNodeType each : EnumNodeType.values()) {
            EnumNodeType defined = pool.get(each.getValue());
            if (null != defined) {
                pool.put(null, null);
            }
            pool.put(each.getValue(), each);
        }
    }


    EnumNodeType(Integer code, String message) {
        this.value = code;
        this.text = message;
    }


    public static EnumNodeType valueOf(Integer code) {
        return pool.get(code);
    }

    public Integer getValue() {
        return this.value;
    }

    public String getText() {
        return text;
    }
}
