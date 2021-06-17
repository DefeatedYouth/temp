package cn.exrick.xboot.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 缺陷状态 0正常 1：一般 2：严重，3：危急
 * @author： hfl
 * @date：2020/9/30 17:29
 * @File: EnumDefectStatusu
 */
public enum EnumSwitchState {
    //asda
    Shut(0,"关闭"),
    //asdasda
    Open(1, "开启");
    private Integer value;
    private String text;

    private static Map<Integer, EnumSwitchState> pool = new HashMap<Integer, EnumSwitchState>();

    static {
        for (EnumSwitchState each : EnumSwitchState.values()) {
            EnumSwitchState defined = pool.get(each.getValue());
            if (null != defined) {
                pool.put(null, null);
            }
            pool.put(each.getValue(), each);
        }
    }


    EnumSwitchState(Integer code, String message) {
        this.value = code;
        this.text = message;
    }


    public static EnumSwitchState valueOf(Integer code) {
        return pool.get(code);
    }

    public Integer getValue() {
        return this.value;
    }

    public String getText() {
        return text;
    }
}
