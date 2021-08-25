package com.sgcc.bd.overallview.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: com.face.ele.smart.modules.smart.constants
 * @description:  init(1, "进行中") finish(2, "已完成")  pause(3, "暂停")
 * @author: dadi
 * @create: 2020-05-28 17:12
 */

public enum EnumPatrolRunStatus {

    //ASD
    notstart(1, "未开始"),
    underway(2, "进行中"),
    finish(3, "已完成"),
    termination(4, "终止"),
    pause(5, "暂停"),
    exceed(7, "超期"),
    confirm(6, "已确认");

    private Integer value;
    private String text;

    private static Map<Integer, EnumPatrolRunStatus> pool = new HashMap<Integer, EnumPatrolRunStatus>();

    static {
        for (EnumPatrolRunStatus each : EnumPatrolRunStatus.values()) {
            EnumPatrolRunStatus defined = pool.get(each.getValue());
            if (null != defined) {
                pool.put(null, null);
            }
            pool.put(each.getValue(), each);
        }
    }


    EnumPatrolRunStatus(Integer code, String message) {
        this.value = code;
        this.text = message;
    }


    public static EnumPatrolRunStatus valueOf(Integer code) {
        return pool.get(code);
    }

    public Integer getValue() {
        return this.value;
    }

    public String getText() {
        return text;
    }
}
