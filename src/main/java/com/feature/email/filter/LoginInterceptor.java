package com.feature.email.filter;

import com.feature.email.common.Enum.Constant;
import com.feature.email.controller.NoLoginValidateController;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class LoginInterceptor extends HandlerInterceptorAdapter {

    /**
     * 登录验证：验证用户是否已登录
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestUrl = request.getRequestURI().replace(request.getContextPath(), "");
        if (isLoginUrl(requestUrl)) {
            return true;
        }
        //若实现了无须登录的接口则返回true
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        if (handlerMethod.getBean() instanceof NoLoginValidateController) {
            return true;
        }
        //判断session
        if (isLogin(request)) {
            return true;
        } else {
            //登录接口地址："http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath() + "/user/login"
//            response.sendRedirect();    //重定向登录页
            return false;
        }
    }

    private static boolean isLogin(HttpServletRequest request) {
        return request.getSession().getAttribute(Constant.SESSION_INFO_PARAMS) != null;
    }

    private static List<String> loginUrl;

    static {
        loginUrl = new ArrayList<>();
        loginUrl.add("/user/register");
        loginUrl.add("/user/login");
    }

    private static boolean isLoginUrl(String requestUrl) {
        for (String url : loginUrl) {
            if (requestUrl.startsWith(url)) {
                return true;
            }
        }
        return false;
    }
}
