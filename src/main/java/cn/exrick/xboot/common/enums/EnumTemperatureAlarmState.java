package cn.exrick.xboot.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/6/17 11:08
 * @File: EnumTemperatureAlarmState
 */
public enum EnumTemperatureAlarmState {
    //asda
    UnAlarm(0,"未报警"),
    //asdasda
    Alarm(1, "已报警");
    private Integer value;
    private String text;

    private static Map<Integer, EnumTemperatureAlarmState> pool = new HashMap<Integer, EnumTemperatureAlarmState>();

    static {
        for (EnumTemperatureAlarmState each : EnumTemperatureAlarmState.values()) {
            EnumTemperatureAlarmState defined = pool.get(each.getValue());
            if (null != defined) {
                pool.put(null, null);
            }
            pool.put(each.getValue(), each);
        }
    }


    EnumTemperatureAlarmState(Integer code, String message) {
        this.value = code;
        this.text = message;
    }


    public static EnumTemperatureAlarmState valueOf(Integer code) {
        return pool.get(code);
    }

    public Integer getValue() {
        return this.value;
    }

    public String getText() {
        return text;
    }
}
