package cn.exrick.xboot.common.enums.stm;

import com.google.common.collect.Maps;

import java.util.*;

/**
 * @author chenfeixiang6@163.com
 * @date 2021/3/19
 * @desc 器具状态枚举
 */
public enum ApplianceNewStatusEnum {
    /** process 是否在流程中 */
    UN_KNOWN("未知状态", 500,1),
    KSY("可使用", 1,0),
    ZYZ("作业中", 2,1),
    SYZ("试验中", 3,1),
    JJDQ("即将到期", 4,0),
    XSYC("巡视异常", 5,0),
    CQWJ("超期未检", 6,0),
    JJGQ("即将过期", 7,0),
    YGQ("已过期(未报废)", 8,0),
    BFCK("已报废(报废出库)", 9,0),
    BFZ("报废中", 10,1);

    private String name;
    private Integer code;
    private Integer process;

    public static Map<Integer, ApplianceNewStatusEnum> cache = new HashMap<>();
    public static List<HashMap<String, Object>> allCache = new ArrayList<>();
    public static List<Integer> allCodeAndNoProcess = new ArrayList<>();
    public static List<Integer> allCodeAndInProcess = new ArrayList<>();

    static {
        Arrays.stream(ApplianceNewStatusEnum.values()).forEach(statusEnum -> {
            cache.put(statusEnum.getCode(),statusEnum);
            HashMap<String, Object> e = Maps.newHashMap();
            e.put("name", statusEnum.getName());
            e.put("status", statusEnum.getCode());
            allCache.add(e);
            if (statusEnum.isProcess()){
                allCodeAndInProcess.add(statusEnum.getCode());
            } else {
                allCodeAndNoProcess.add(statusEnum.getCode());
            }
        });
    }
    ApplianceNewStatusEnum(String name, Integer code, Integer process) {
        this.name = name;
        this.code = code;
        this.process = process;
    }
    public boolean isProcess(){
        return this.getProcess() == 1;
    }

    public static ApplianceNewStatusEnum getEnumByCode(Integer code) {
        return cache.get(code);
    }

    public static List<HashMap<String, Object>> getAllEnum() {
        return allCache;
    }

    /**
     * 获取所有 不在流程中 的状态集合
     */
    public static List<Integer> getAllCodeAndNoProcess() {

        return allCodeAndNoProcess;
    }
    /**
        获取所有 在流程中 的状态集合
     */
    public static List<Integer> getAllCodeAndInProcess() {
        return allCodeAndInProcess;
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

    public Integer getProcess() {
        return process;
    }

    public void setProcess(Integer process) {
        this.process = process;
    }
}
