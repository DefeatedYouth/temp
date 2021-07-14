package com.sgcc.bd.overallview.config.interceptor;

import com.sgcc.bd.overallview.common.constant.SecurityConstant;
import com.sgcc.bd.overallview.common.utils.HLStringUtil;
import com.sgcc.bd.overallview.common.utils.ThreadLocalUtil;
import com.sgcc.bd.overallview.config.properties.DefaultUserProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;

/**
 * 用户信息添加
 *
 * @author Exrickx
 */
@Slf4j
@Component
public class UserInfoInterceptor extends HandlerInterceptorAdapter {


    @Autowired
    DefaultUserProperties defaultUserProperties;


    /**
     * currentUserId,
     * currentUserName,
     * currentRealName,
     * currentOrgId,
     * currentOrgParentPath
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {

        String currentUserId = request.getHeader("currentUserId");
        String currentAccount = request.getHeader("currentAccount");
        String currentRealName = request.getHeader("currentRealName")!=null?URLDecoder.decode(request.getHeader("currentRealName")):null;
        String currentOrgId = request.getHeader("currentOrgId");
        String currentOrgPath = request.getHeader("currentOrgPath")!=null?URLDecoder.decode(request.getHeader("currentOrgPath")):null;
        String currentOrgBmxz = request.getHeader("currentOrgBmxz");
        UserBaseInfoDTO userBaseInfoDTO = new UserBaseInfoDTO();
        userBaseInfoDTO.setCurrentUserId(HLStringUtil.isEmptyWithBlank(currentUserId)?defaultUserProperties.getCurrentUserId():currentUserId);
        userBaseInfoDTO.setCurrentAccount(HLStringUtil.isEmptyWithBlank(currentAccount)?defaultUserProperties.getCurrentAccount():currentAccount);
        userBaseInfoDTO.setCurrentRealName(HLStringUtil.isEmptyWithBlank(currentRealName)?defaultUserProperties.getCurrentRealName():currentRealName);
        userBaseInfoDTO.setCurrentOrgId(HLStringUtil.isEmptyWithBlank(currentOrgId)?defaultUserProperties.getCurrentOrgId():currentOrgId);
        userBaseInfoDTO.setCurrentOrgPath(HLStringUtil.isEmptyWithBlank(currentOrgPath)?defaultUserProperties.getCurrentOrgPath():currentOrgPath);
        userBaseInfoDTO.setCurrentOrgBmxz(currentOrgBmxz);
        ThreadLocalUtil.set(SecurityConstant.USER_INFO_KEY, userBaseInfoDTO);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 方法将在整个请求结束之后，也就是在DispatcherServlet渲染了对应的视图之后执行。
     * 这个方法的主要作用是用于进行资源清理工作的。
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
    }

}
