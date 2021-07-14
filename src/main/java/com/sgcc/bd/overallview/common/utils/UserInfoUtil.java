package com.sgcc.bd.overallview.common.utils;


import com.sgcc.bd.overallview.common.constant.SecurityConstant;
import com.sgcc.bd.overallview.config.interceptor.UserBaseInfoDTO;

/**
 * @author Exrickx
 */
public class UserInfoUtil {

    public static UserBaseInfoDTO getUserBaseInfo() {
        return ThreadLocalUtil.get(SecurityConstant.USER_INFO_KEY, null);
    }

}
