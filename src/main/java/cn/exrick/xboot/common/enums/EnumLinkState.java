package cn.exrick.xboot.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 缺陷状态 0正常 1：一般 2：严重，3：危急
 * @author： hfl
 * @date：2020/9/30 17:29
 * @File: EnumDefectStatusu
 */
public enum EnumLinkState {
    //asda
    Untreated(0,"通信正常"),
    //asdasda
    Processed(1, "通信异常");
    private Integer value;
    private String text;

    private static Map<Integer, EnumLinkState> pool = new HashMap<Integer, EnumLinkState>();

    static {
        for (EnumLinkState each : EnumLinkState.values()) {
            EnumLinkState defined = pool.get(each.getValue());
            if (null != defined) {
                pool.put(null, null);
            }
            pool.put(each.getValue(), each);
        }
    }


    EnumLinkState(Integer code, String message) {
        this.value = code;
        this.text = message;
    }


    public static EnumLinkState valueOf(Integer code) {
        return pool.get(code);
    }

    public Integer getValue() {
        return this.value;
    }

    public String getText() {
        return text;
    }
}
