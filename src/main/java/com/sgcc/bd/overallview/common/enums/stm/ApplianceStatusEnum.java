package com.sgcc.bd.overallview.common.enums.stm;

import com.google.common.collect.Maps;

import java.util.*;

/**
 * @author chenfeixiang6@163.com
 * @date 2021/3/19
 * @desc 器具状态枚举
 */
public enum ApplianceStatusEnum {
    /** process 是否在流程中 */
    UN_KNOWN("未知状态", 500,0),
    KSY("可使用", 0,0),
    SYZ("使用中", 1,1),
    XSYC("巡视异常", 2,0),
    CQWJ("超期未检", 3,0),
    DSY("待试验", 4,1),
    SYZZ("试验中", 5,1),
    DPF("待配发", 6,1),
    YPF("已配发", 7,1),
    DBF("待报废", 8,0),
    YFC("已返厂", 9,0),
    BFCK("已报废", 10,0),
    XPDFJ("新品待分拣", 11,1),
    JJDQ("即将到期", 12,0),
    XPRK("采购入库", 13,1),
    SYZXP("试验中(新品)", 14,1),
    BP("备品", 15,0),
    DFC("待返厂", 16,1),
    //快到保质期，有效期小于30天
    JJGQ("即将过期", 17,0),
    GQWBF("过期未报废", 18,0);

    private String name;
    private Integer code;
    private Integer process;

    public static Map<Integer, ApplianceStatusEnum> cache = new HashMap<>();
    public static List<HashMap<String, Object>> allCache = new ArrayList<>();
    public static List<Integer> allCodeAndNoProcess = new ArrayList<>();
    public static List<Integer> allCodeAndInProcess = new ArrayList<>();

    static {
        Arrays.stream(ApplianceStatusEnum.values()).forEach(statusEnum -> {
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
    ApplianceStatusEnum(String name, Integer code,Integer process) {
        this.name = name;
        this.code = code;
        this.process = process;
    }
    public boolean isProcess(){
        return this.getProcess() == 1;
    }

    public static ApplianceStatusEnum getEnumByCode(Integer code) {
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
