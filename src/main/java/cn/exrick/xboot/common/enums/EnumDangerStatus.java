package cn.exrick.xboot.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 缺陷状态 0正常 1：一般 2：严重，3：危急
 * @author： hfl
 * @date：2020/9/30 17:29
 * @File: EnumDefectStatus
 */
public enum EnumDangerStatus {
    common(1, "一般"),
    severity(2, "严重"),
    notdefect(0, "正常");

    private Integer value;
    private String text;

    private static Map<Integer, EnumDangerStatus> pool = new HashMap<Integer, EnumDangerStatus>();

    static {
        for (EnumDangerStatus each : EnumDangerStatus.values()) {
            EnumDangerStatus defined = pool.get(each.getValue());
            if (null != defined) {
                pool.put(null, null);
            }
            pool.put(each.getValue(), each);
        }
    }


    EnumDangerStatus(Integer code, String message) {
        this.value = code;
        this.text = message;
    }


    public static EnumDangerStatus valueOf(Integer code) {
        return pool.get(code);
    }

    public Integer getValue() {
        return this.value;
    }

    public String getText() {
        return text;
    }
}
