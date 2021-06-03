package cn.exrick.xboot.common.enums.stm;

import com.google.common.collect.Maps;

import java.util.*;

/**
 * @author chenfeixiang6@163.com
 * @date 2021/4/21
 * @desc 出入库类型枚举
 */
public enum BusinessOutInTypeEnum {
    /** 出入库类型枚举 */
    CK_SY("试验出库", 10),
    RK_SY("试验入库", 11),
    CK_SY_SC("试验试验中心出库", 20),
    RK_SY_SC("试验试验中心入库", 21),
    CK_LY("领用单出库", 30),
    RK_LY("领用单入库", 40),
    CK_BF("报废出库", 50);

    private String name;
    private Integer code;

    public static Map<Integer, BusinessOutInTypeEnum> cache = new HashMap<>();
    public static List<HashMap<String, Object>> allCache = new ArrayList<>();

    static {
        Arrays.stream(BusinessOutInTypeEnum.values()).forEach(statusEnum -> {
            cache.put(statusEnum.getCode(),statusEnum);
            HashMap<String, Object> e = Maps.newHashMap();
            e.put("name", statusEnum.getName());
            e.put("status", statusEnum.getCode());
            allCache.add(e);
        });
    }
    BusinessOutInTypeEnum(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    public static BusinessOutInTypeEnum getEnumByCode(Integer code) {
        return cache.get(code);
    }

    public static List<HashMap<String, Object>> getAllEnum() {
        return allCache;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
