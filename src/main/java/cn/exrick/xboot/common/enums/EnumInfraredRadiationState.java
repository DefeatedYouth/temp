package cn.exrick.xboot.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/6/22 11:54
 * @File: EnumInfraredRadiationState
 */
public enum  EnumInfraredRadiationState {

    //asda
    DeviceFailure(0,"装置故障"),
    //asdasda
    AbnormalCommunication(1, "通信异常"),

    AbnormalPowerSupply(2, "电源异常"),
    ControllerFailure(3, "控制器故障");
    private Integer value;
    private String text;

    private static Map<Integer, EnumInfraredRadiationState> pool = new HashMap<Integer, EnumInfraredRadiationState>();

    static {
        for (EnumInfraredRadiationState each : EnumInfraredRadiationState.values()) {
            EnumInfraredRadiationState defined = pool.get(each.getValue());
            if (null != defined) {
                pool.put(null, null);
            }
            pool.put(each.getValue(), each);
        }
    }


    EnumInfraredRadiationState(Integer code, String message) {
        this.value = code;
        this.text = message;
    }


    public static EnumInfraredRadiationState valueOf(Integer code) {
        return pool.get(code);
    }

    public Integer getValue() {
        return this.value;
    }

    public String getText() {
        return text;
    }
}
