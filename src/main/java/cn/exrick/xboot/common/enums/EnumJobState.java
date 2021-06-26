package cn.exrick.xboot.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/6/26 17:09
 * @File: EnumJobState
 */
public enum EnumJobState {
    //asda
    Processing(1,"进行中"),
    Notstarted(2,"未开始"),
    //asdasda
    Completed(3, "已完成");
    private Integer value;
    private String text;

    private static Map<Integer, EnumJobState> pool = new HashMap<Integer, EnumJobState>();

    static {
        for (EnumJobState each : EnumJobState.values()) {
            EnumJobState defined = pool.get(each.getValue());
            if (null != defined) {
                pool.put(null, null);
            }
            pool.put(each.getValue(), each);
        }
    }


    EnumJobState(Integer code, String message) {
        this.value = code;
        this.text = message;
    }


    public static EnumJobState valueOf(Integer code) {
        return pool.get(code);
    }

    public Integer getValue() {
        return this.value;
    }

    public String getText() {
        return text;
    }
}
