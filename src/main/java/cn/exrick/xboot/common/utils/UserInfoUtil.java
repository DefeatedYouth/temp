package cn.exrick.xboot.common.utils;


import cn.exrick.xboot.common.constant.SecurityConstant;
import cn.exrick.xboot.config.interceptor.UserBaseInfoDTO;

/**
 * @author Exrickx
 */
public class UserInfoUtil {

    public static UserBaseInfoDTO getUserBaseInfo() {
        return ThreadLocalUtil.get(SecurityConstant.USER_INFO_KEY, null);
    }

}
