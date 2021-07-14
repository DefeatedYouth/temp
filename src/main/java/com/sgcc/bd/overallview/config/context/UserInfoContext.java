package com.sgcc.bd.overallview.config.context;


import com.sgcc.bd.overallview.common.constant.SecurityConstant;
import com.sgcc.bd.overallview.common.utils.ThreadLocalUtil;
import com.sgcc.bd.overallview.config.interceptor.UserBaseInfoDTO;

/**
 * @author chenfeixiang6@163.com
 * @date 2021/4/6
 * @desc
 */
public class UserInfoContext {

    public static UserBaseInfoDTO getUserBaseInfo() {
        return ThreadLocalUtil.get(SecurityConstant.USER_INFO_KEY, new UserBaseInfoDTO());
    }

}
