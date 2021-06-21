package cn.exrick.xboot.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: TODO
 * @author： hfl
 * @date：2020/10/3 10:01
 * @File: EnumPrimaryType
 */
public enum EnumPrimaryType {
    //
    Transformer(1, "油浸式变压器(电抗器)"),
    CircuitBreaker(2, "断路器"),
    IsolatingSwitch(4, "隔离开关"),
;
    private Integer value;
    private String text;

    private static Map<Integer, EnumPrimaryType> pool = new HashMap<Integer, EnumPrimaryType>();

    static {
        for (EnumPrimaryType each : EnumPrimaryType.values()) {
            EnumPrimaryType defined = pool.get(each.getValue());
            if (null != defined) {
                pool.put(null, null);
            }
            pool.put(each.getValue(), each);
        }
    }


    EnumPrimaryType(Integer code, String message) {
        this.value = code;
        this.text = message;
    }


    public static EnumPrimaryType valueOf(Integer code) {
        return pool.get(code);
    }

    public Integer getValue() {
        return this.value;
    }

    public String getText() {
        return text;
    }
}
