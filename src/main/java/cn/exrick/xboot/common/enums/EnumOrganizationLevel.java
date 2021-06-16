package cn.exrick.xboot.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 1地市公司 2工区 3班组
 */
public enum EnumOrganizationLevel {
    MunicipalCompany(1, "地市公司"),
    WorkArea(2, "工区"),
    Eam(3, "班组");

    private Integer value;
    private String text;

    private static Map<Integer, EnumOrganizationLevel> pool = new HashMap<Integer, EnumOrganizationLevel>();
    private static Map<String, EnumOrganizationLevel> textPool = new HashMap<String, EnumOrganizationLevel>();

    static {
        for (EnumOrganizationLevel each : EnumOrganizationLevel.values()) {
            EnumOrganizationLevel defined = pool.get(each.getValue());
            if (null != defined) {
                pool.put(null, null);
            }
            pool.put(each.getValue(), each);
            textPool.put(each.getText(), each);
        }
    }


    EnumOrganizationLevel(Integer code, String message) {
        this.value = code;
        this.text = message;
    }


    public static EnumOrganizationLevel valueOf(Integer code) {
        return pool.get(code);
    }
    public static EnumOrganizationLevel textOf(String text) {
        return textPool.get(text);
    }

    public Integer getValue() {
        return this.value;
    }

    public String getText() {
        return text;
    }
}

