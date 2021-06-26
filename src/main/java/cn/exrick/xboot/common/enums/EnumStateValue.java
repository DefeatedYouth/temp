package cn.exrick.xboot.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/6/26 15:09
 * @File: EnumStateValue
 */
public enum EnumStateValue {
    //
    Untreated(0, "未处理"),
    Processed(1, "已处理");
    private Integer value;
    private String text;

    private static Map<Integer, EnumStateValue> pool = new HashMap<Integer, EnumStateValue>();

    static {
        for (EnumStateValue each : EnumStateValue.values()) {
            EnumStateValue defined = pool.get(each.getValue());
            if (null != defined) {
                pool.put(null, null);
            }
            pool.put(each.getValue(), each);
        }
    }


    EnumStateValue(Integer code, String message) {
        this.value = code;
        this.text = message;
    }


    public static EnumStateValue valueOf(Integer code) {
        return pool.get(code);
    }

    public Integer getValue() {
        return this.value;
    }

    public String getText() {
        return text;
    }
}
