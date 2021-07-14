package com.sgcc.bd.overallview.common.enums.stm;

import com.google.common.collect.Maps;

import java.util.*;

/**
 * @author chenfeixiang6@163.com
 * @date 2021/3/26
 * @desc 器具分类试验类型枚举
 */
public enum CategoryExpTypeEnum {
    /** 器具分类试验类型枚举 */

    A("普通耐压测试", "A"),
    B("杆类耐压测试", "B"),
    C("组合拉力测试", "C"),
    D("电阻测试", "D"),
    E("杆类耐压带启动电压", "E"),
    F("耐压测试带泄漏电流", "F"),
    G("杆加线类耐压电与阻测试", "G"),
    X("器具不存在或器具非试验器具", "X");

    private String name;
    private String code;

    public static Map<String, CategoryExpTypeEnum> cache = new HashMap<>();
    public static List<HashMap<String, Object>> allCache = new ArrayList<>();

    static {
        Arrays.stream(CategoryExpTypeEnum.values()).forEach(statusEnum -> {
            cache.put(statusEnum.getCode(),statusEnum);
            HashMap<String, Object> e = Maps.newHashMap();
            e.put("name", statusEnum.getName());
            e.put("status", statusEnum.getCode());
            allCache.add(e);
        });
    }
    CategoryExpTypeEnum(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public static CategoryExpTypeEnum getEnumByCode(String code) {
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
