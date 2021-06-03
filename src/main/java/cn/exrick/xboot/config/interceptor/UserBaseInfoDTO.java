package cn.exrick.xboot.config.interceptor;/**
 * @ProjectName: fj_aqj_backend_new
 * @Package: cn.exrick.xboot.config.interceptor
 * @ClassName: UserBaseInfoDTO
 * @Author: dadi
 * @Description:
 * @Date: 2021/4/1 11:33
 */

import lombok.Data;

/**
 * @program: cn.exrick.xboot.config.interceptor
 * @description:
 * @author: dadi
 * @create: 2021-04-01 11:33
 */
@Data
public class UserBaseInfoDTO {
    String currentUserId;
    String currentAccount;
    String currentRealName;
    String currentOrgId;
    String currentOrgPath;
    String currentOrgName;
    String currentOrgBmxz;  //部门性质
    String currentUserType;
}
