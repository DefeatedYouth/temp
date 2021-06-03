package cn.exrick.xboot.common.utils;

import java.util.Collections;
import java.util.List;

/**
 * @author chenfeixiang6@163.com
 * @date 2021/3/18
 * @desc
 */
public class StringSortUtil {
    public static String getSortApplianceSpec(String spec){
        StringBuilder newSpec = new StringBuilder();
        List<String> list = HLCollectionUtil.arrayToList(spec.split(","));
        Collections.sort(list, (o1, o2) -> o1 .compareTo(o2));
        for (String one : list) {
            newSpec.append(one);
        }
        return newSpec.toString();
    }
}
