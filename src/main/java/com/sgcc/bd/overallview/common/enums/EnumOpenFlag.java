package com.sgcc.bd.overallview.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/6/22 15:05
 * @File: EnumOpenFlag
 */
public enum EnumOpenFlag {

    //asda
    Open(0,"布防状态"),
    //asdasda
    Down(1, "关闭状态");
    private Integer value;
    private String text;

    private static Map<Integer, EnumOpenFlag> pool = new HashMap<Integer, EnumOpenFlag>();

    static {
        for (EnumOpenFlag each : EnumOpenFlag.values()) {
            EnumOpenFlag defined = pool.get(each.getValue());
            if (null != defined) {
                pool.put(null, null);
            }
            pool.put(each.getValue(), each);
        }
    }


    EnumOpenFlag(Integer code, String message) {
        this.value = code;
        this.text = message;
    }


    public static EnumOpenFlag valueOf(Integer code) {
        return pool.get(code);
    }

    public Integer getValue() {
        return this.value;
    }

    public String getText() {
        return text;
    }
}
