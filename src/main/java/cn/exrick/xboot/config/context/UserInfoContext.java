package cn.exrick.xboot.config.context;


import cn.exrick.xboot.common.constant.SecurityConstant;
import cn.exrick.xboot.common.utils.ThreadLocalUtil;
import cn.exrick.xboot.config.interceptor.UserBaseInfoDTO;

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
