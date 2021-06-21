package cn.exrick.xboot.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/6/21 16:20
 * @File: EnumAxfDeviceType
 */
public enum  EnumAxfDeviceType {
    Nomal(1,"变压器消防监视列表"),
    Accident(2, "烟感探测器监视列表"),
    Abnormal(3, "火灾探测器消防监视列表"),
    CrossLine(4, "消防装置故障监视列表"),
    Displacement(5, "门禁异常监视列表"),
/*    Displacement(6, "门禁故障监视列表"),
    Displacement(7, "门禁报警监视列表"),
    Displacement(8, "电源故障监视列表"),
    Displacement(9, "通讯异常监视列表"),
    Displacement(10, "防区报警监视列表"),
    Displacement(13, "监控告警监视列表"),
    Displacement(15, "电源异常监视列表"),
    Displacement(16, "报警监视列表"),
    Displacement(17, "故障监视列表"),*/
    Inform(19, "告知");
    private Integer value;
    private String text;

    private static Map<Integer, EnumAxfDeviceType> pool = new HashMap<Integer, EnumAxfDeviceType>();

    static {
        for (EnumAxfDeviceType each : EnumAxfDeviceType.values()) {
            EnumAxfDeviceType defined = pool.get(each.getValue());
            if (null != defined) {
                pool.put(null, null);
            }
            pool.put(each.getValue(), each);
        }
    }


    EnumAxfDeviceType(Integer code, String message) {
        this.value = code;
        this.text = message;
    }


    public static EnumAxfDeviceType valueOf(Integer code) {
        return pool.get(code);
    }

    public Integer getValue() {
        return this.value;
    }

    public String getText() {
        return text;
    }
}
