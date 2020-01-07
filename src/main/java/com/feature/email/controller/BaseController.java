package com.feature.email.controller;

import com.feature.email.common.Enum.BaseErrorMsg;
import com.feature.email.common.Enum.Constant;
import com.feature.email.common.Exception.DIYException;
import com.feature.email.entityVo.user.UserVo;
import lombok.extern.log4j.Log4j2;

import javax.servlet.http.HttpServletRequest;


/**
 * 通用基础
 *
 * @description: BaseController <br>
 * @date: 2020/1/7 11:03 <br>
 * @author: luoyl <br>
 * @version: 1.0 <br>
 */
@Log4j2
public class BaseController {

    /**
     * 获取用户信息(需要用户登录)
     *
     * @param request
     * @return
     */
    public UserVo getUserInfo(HttpServletRequest request) {
        UserVo userVo = null;
        try {
            userVo = (UserVo) request.getSession().getAttribute(Constant.SESSION_INFO_PARAMS);
        } catch (Exception e) {
            throw new DIYException(BaseErrorMsg.sessionInfoIsNull.getMsg(), e);
        }
        return userVo;
    }
}
