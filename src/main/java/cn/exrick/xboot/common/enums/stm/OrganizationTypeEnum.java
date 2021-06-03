package cn.exrick.xboot.common.enums.stm;

import com.google.common.collect.Maps;

import java.util.*;

/**
 * @author chenfeixiang6@163.com
 * @date 2021/3/19
 * @desc 器具状态枚举
 */
public enum OrganizationTypeEnum {
    /**
     *  BMXZNAME 枚举值，XZ2 社会承包商，XZ7 社会承包商班组，XZ13 队伍
     */
    XZ1("配电班组", 1,0),
    XZ2("社会承包商", 2,1),
    XZ3("平台集体企业", 3,0),
    XZ4("班组", 4,0),
    XZ5("集体企业工作班组", 5,0),
    XZ6("变电班组", 6,0),
    XZ7("社会承包商班组", 7,1),
    XZ8("部门", 8,0),
    XZ9("县级公司", 9,0),
    XZ10("单位", 10,0),
    XZ11("综合班组", 11,0),
    XZ12("集体企业分包队伍", 12,0),
    XZ13("队伍", 13,1);

    private String name;
    private Integer code;
    //是否是外协 0 是主业 1 是外协
    private Integer isOut;

    public static Map<Integer, OrganizationTypeEnum> cache = new HashMap<>();
    public static List<HashMap<String, Object>> allCache = new ArrayList<>();
    public static List<String> allMainList = new ArrayList<>();
    public static List<String> allOutList = new ArrayList<>();

    static {
        Arrays.stream(OrganizationTypeEnum.values()).forEach(statusEnum -> {
            cache.put(statusEnum.getCode(),statusEnum);
            HashMap<String, Object> e = Maps.newHashMap();
            e.put("name", statusEnum.getName());
            e.put("status", statusEnum.getCode());
            allCache.add(e);
            if (statusEnum.isOut()){
                allOutList.add(statusEnum.getName());
            } else {
                allMainList.add(statusEnum.getName());
            }
        });
    }
    OrganizationTypeEnum(String name, Integer code, Integer isOut) {
        this.name = name;
        this.code = code;
        this.isOut = isOut;
    }
    public boolean isOut(){
        return this.getIsOut() == 1;
    }

    public static OrganizationTypeEnum getEnumByCode(Integer code) {
        return cache.get(code);
    }

    public static List<HashMap<String, Object>> getAllEnum() {
        return allCache;
    }

    /**
     * 获取所有 主业 的状态集合
     */
    public static List<String> getAllMain() {

        return allMainList;
    }
    /**
        获取所有 外协队伍 的集合
     */
    public static List<String> getAllOut() {
        return allOutList;
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

    public Integer getIsOut() {
        return isOut;
    }

    public void setIsOut(Integer isOut) {
        this.isOut = isOut;
    }
}
