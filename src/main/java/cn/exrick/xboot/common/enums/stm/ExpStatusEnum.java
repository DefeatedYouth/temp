package cn.exrick.xboot.common.enums.stm;

import com.google.common.collect.Maps;

import java.util.*;

/**
 * @author chenfeixiang6@163.com
 * @date 2021/3/30
 * @desc 试验状态枚举
 */
public enum ExpStatusEnum {
    /** 试验状态：1=班组待出库，2=试验中心待入库，3=试验中，4=待校准，5=待批准，6=待分配，7=待配发（试验中心出库），8=班组待入库，9=已完成 */
    BZ_DCK("班组待出库", 1),
    SY_DRK("试验中心待入库", 2),
    SY_SYZ("试验中", 3),
    SY_DXZ("待校准", 4),
    SY_DPZ("待批准", 5),
    SY_DFP("待分配", 6),
    SY_DPF("待配发(试验中心待出库)", 7),
    BZ_DRK("班组待入库", 8),
    BZ_YWC("已完成", 9);

    private String name;
    private Integer code;

    public static Map<Integer, ExpStatusEnum> cache = new HashMap<>();
    public static List<HashMap<String, Object>> allCache = new ArrayList<>();

    static {
        Arrays.stream(ExpStatusEnum.values()).forEach(statusEnum -> {
            cache.put(statusEnum.getCode(),statusEnum);
            HashMap<String, Object> e = Maps.newHashMap();
            e.put("name", statusEnum.getName());
            e.put("status", statusEnum.getCode());
            allCache.add(e);
        });
    }
    ExpStatusEnum(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    public static ExpStatusEnum getEnumByCode(Integer code) {
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
