package com.sgcc.bd.overallview.common.utils;


import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author chenfeixiang6@163.com
 * @date 2021/3/30
 * @desc
 */
public class HLStringUtil extends StringUtils {

    private static final String BLANK_SPACE_STRING = " ";

    /**
     * 字符串为【null】 或者是 【空串】 返回true
     * @param cs
     * @return
     */
    public static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;

    }
    /**
     * 字符串为【null】 或者是 【空串】 或者是【空格】返回true
     * @param cs
     * @return
     */
    public static boolean isEmptyWithBlank(final CharSequence cs) {
        return cs == null || cs.length() == 0 || replace(cs.toString(),BLANK_SPACE_STRING,"").length() == 0;

    }
    /**
     * 字符串不是【null】 并且不是 【空串】 并且不是【空格】返回true
     * @param cs
     * @return
     */
    public static boolean isNotEmptyWithBlank(final CharSequence cs) {
        return cs != null && replace(cs.toString(),BLANK_SPACE_STRING,"").length() > 0;

    }

    /**
     * 字符串不是【null】 并且不是 【空串】返回true
     * @param cs
     * @return
     */
    public static boolean isNotEmpty(final CharSequence cs) {
        return cs != null && cs.length() > 0;

    }

   /* public static boolean isNumber(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }*/
}

