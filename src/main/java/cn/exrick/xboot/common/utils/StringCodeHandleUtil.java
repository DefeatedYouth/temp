package cn.exrick.xboot.common.utils;

import cn.exrick.xboot.common.exception.XbootException;

/**
 * @author chenfeixiang6@163.com
 * @date 2021/4/29
 * @desc
 */
public class StringCodeHandleUtil {

    private final static String TARGET_VOLTAGE = "kV";


    // 试验参数配置表 截面积
    private final static String MM2_AREA_CONFIG = "mm2";
    //规格名称与试验参数（部分） 截面积
    private final static String ASK_AREA_CONFIG = "mm?";
    //导入的excel的 截面积
    private final static String PFM_AREA_CONFIG = "mm²";

    /**
     * 替换电压 等级大小写
     *
     * @param oldVoltage
     * @return
     */
    public static String replaceVoltageStr(String oldVoltage) {
        if (HLStringUtil.isEmptyWithBlank(oldVoltage)) {
            return oldVoltage;
        }
        return oldVoltage.replace("KV", TARGET_VOLTAGE)
                .replace("Kv", TARGET_VOLTAGE)
                .replace("kv", TARGET_VOLTAGE);
    }


    /**
     * 获取从 字符串中 提取 电压等级
     *
     * @param oldVoltage
     * @return
     */
    public static String getVoltageStr(String oldVoltage) {
        String targetStr = "";
        if (HLStringUtil.isEmptyWithBlank(oldVoltage)) {
            return oldVoltage;
        }
        if (
                oldVoltage.contains(TARGET_VOLTAGE)
                        || oldVoltage.contains("KV")
                        || oldVoltage.contains("Kv")
                        || oldVoltage.contains("kv")
        ) {
            String[] split = oldVoltage.split(",");
            for (String s : split) {
                if (s.endsWith(TARGET_VOLTAGE)
                        || s.endsWith("KV")
                        || s.endsWith("Kv")
                        || s.endsWith("kv")
                ) {
                    targetStr = s.replace("KV", TARGET_VOLTAGE)
                            .replace("Kv", TARGET_VOLTAGE)
                            .replace("kv", TARGET_VOLTAGE);
                }
            }
        }
        return targetStr;
    }

    /**
     * 校验 定制编号合理性
     *
     * @param serialNum
     * @return
     */
    public static boolean checkApplianceSerialNum(String serialNum) {
        if (HLStringUtil.isEmptyWithBlank(serialNum)) {
            throw new XbootException("定制编号不能为空");
        }
        if (!serialNum.startsWith("#")){
            throw new XbootException("定制编号必须以#号开头");
        }
        String replace = serialNum.replace("#", "");
        boolean isNunicodeDigits = HLStringUtil.isNumber(replace);
        if (!isNunicodeDigits){
            throw new XbootException("定制编号#尾部必须是数字");
        }
        return true;
    }

    // mm？或 mm² 转 mm2
    public static String replaceAreaTo2(String target) {
        return target.replace(ASK_AREA_CONFIG, MM2_AREA_CONFIG).replace(PFM_AREA_CONFIG,MM2_AREA_CONFIG);
    }
    // mm² 或 mm2 转成 mm?
    public static String replaceAreaToAsk(String target) {
        return target.replace(PFM_AREA_CONFIG, ASK_AREA_CONFIG).replace(MM2_AREA_CONFIG,ASK_AREA_CONFIG);
    }
}
