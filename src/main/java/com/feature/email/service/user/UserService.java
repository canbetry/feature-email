package com.feature.email.service.user;

import com.feature.email.common.Enum.BaseErrorMsg;
import com.feature.email.common.Enum.Constant;
import com.feature.email.common.Enum.UserEnum;
import com.feature.email.common.Response.ResponseEntity;
import com.feature.email.dao.user.UserMapper;
import com.feature.email.entity.user.User;
import com.feature.email.entityVo.user.UserVo;
import com.feature.email.utils.Base64Utils;
import com.feature.email.utils.CommonBeanUtils;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;


/**
 * Spring5开始，spring默认使用CGLIB动态代理，因此不需要通过实现接口进行依赖注入和查找
 */
@Service("userService")
@Log4j2
@SuppressWarnings("all")
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 注册用户
     *
     * @param userVo
     * @return
     */
    @Transactional
    public ResponseEntity<UserVo> saveUser(UserVo userVo) {
        //注册用户检查核心字段是否为空
        if (StringUtils.isBlank(userVo.getUserName()) || StringUtils.isBlank(userVo.getUserPassword())
                || StringUtils.isBlank(userVo.getUserEmail()) || StringUtils.isBlank(userVo.getUserType())) {
            return ResponseEntity.errorInfo(UserEnum.$userInfoNotComplete);
        }
        //检查用户名是否已被占用
        User userMsg = userMapper.queryByUserName(userVo.getUserName());
        if (CommonBeanUtils.objectIsNotEmpty(userMsg)) {
            return ResponseEntity.errorInfo(UserEnum.$userIsExisted);
        }
        //检查邮箱是否已被占用
        User userEmailMsg = userMapper.queryByUserEmail(userVo.getUserEmail());
        if (CommonBeanUtils.objectIsNotEmpty(userEmailMsg)) {
            return ResponseEntity.errorInfo(UserEnum.$userEmailIsExits);
        }
        //每个注册用户独有的盐值，通过盐值加密码进行校验
        String salt = Base64Utils.generateMixRandomCode();
        String pwd = null;
        try {
            pwd = Base64Utils.decodeStr(userVo.getUserPassword());
        } catch (UnsupportedEncodingException e) {
            log.error(BaseErrorMsg.decryptPwdFail, e);
            return ResponseEntity.errorInfo(UserEnum.$registerFailed);
        }
        String newPwd = (pwd + salt);
        User user = new User();
        user.setUserName(userVo.getUserName());
        try {
            user.setUserPassword(Base64Utils.encodeStr(newPwd));
        } catch (UnsupportedEncodingException e) {
            log.error(BaseErrorMsg.encryptPwdFail, e);
            return ResponseEntity.errorInfo(UserEnum.$registerFailed);
        }
        user.setUserType(userVo.getUserType());
        user.setSalt(salt);
        String userEmail = null;
        try {
            userEmail = Base64Utils.decodeStr(userVo.getUserEmail());
        } catch (UnsupportedEncodingException e) {
            log.error(BaseErrorMsg.decryptPwdFail, e);
            return ResponseEntity.errorInfo(UserEnum.$registerFailed);
        }
        try {
            user.setUserEmail(Base64Utils.encodeStr(userEmail + salt));
        } catch (UnsupportedEncodingException e) {
            log.error(BaseErrorMsg.encryptPwdFail, e);
            return ResponseEntity.errorInfo(UserEnum.$registerFailed);
        }
        if (StringUtils.isNotBlank(userVo.getCustName())) {
            user.setCustName(userVo.getCustName());
        }
        Integer integer = userMapper.saveUser(user);
        if (integer == 1) {
            return ResponseEntity.responseBySucceedMessage(Constant.SUCCESS_MESSAGE);
        } else {
            return ResponseEntity.responseByErrorMessage(UserEnum.$registerFailed.getMessage());
        }
    }


    /**
     * 用户登录
     *
     * @param userVo
     * @return
     */
    public ResponseEntity<UserVo> userLogin(UserVo userVo, HttpServletRequest request) {
        //检查用户登录名合用户密码(加密)是否为空
        if (StringUtils.isBlank(userVo.getUserName()) || StringUtils.isBlank(userVo.getUserPassword())) {
            return ResponseEntity.errorInfo(UserEnum.$userInfoIsNull);
        }
        User user = userMapper.queryByUserName(userVo.getUserName());
        //校验密码
        String loginPwd = null;
        try {
            loginPwd = Base64Utils.decodeStr(userVo.getUserPassword());
        } catch (UnsupportedEncodingException e) {
            log.error(BaseErrorMsg.decryptPwdFail, e);
            return ResponseEntity.errorInfo(UserEnum.$loginFailed);
        }
        String encodePwd = null;
        try {
            encodePwd = Base64Utils.encodeStr(loginPwd + user.getSalt());
        } catch (UnsupportedEncodingException e) {
            log.error(BaseErrorMsg.encryptPwdFail, e);
            return ResponseEntity.errorInfo(UserEnum.$loginFailed);
        }
        if (!encodePwd.equals(user.getUserPassword())) {
            return ResponseEntity.errorInfo(UserEnum.$userPasswordError);
        }
        BeanUtils.copyProperties(user, userVo);
        //登陆成功将用户信息放于session中
        request.getSession().setAttribute(Constant.SESSION_INFO_PARAMS, userVo);
        return ResponseEntity.responseBySucceed(UserEnum.$loginSuccess.getMessage());
    }


    /**
     * 用户登出
     *
     * @param request
     * @return
     */
    public ResponseEntity userLogout(HttpServletRequest request) {
        request.getSession().removeAttribute(Constant.SESSION_INFO_PARAMS);
        return ResponseEntity.SUCCEED;
    }


    /**
     * 更新用户信息
     *
     * @param userVo
     * @return
     */
    @Transactional
    public ResponseEntity updateUser(UserVo userVo) {
        //如果昵称不为空，检查用户名是否已被占用
        if (StringUtils.isNotBlank(userVo.getUserName())) {
            User userMsg = userMapper.queryByUserName(userVo.getUserName());
            if (userMsg != null) {
                //昵称已被占用
                if (userVo.getUserName().equals(userMsg.getUserName()) && userVo.getId() != userMsg.getId()) {
                    return ResponseEntity.errorInfo(UserEnum.$userNameIsExits);
                }
            }
        }
        //如果邮箱不为空，检验邮箱是否已被占用
        if (StringUtils.isNotBlank(userVo.getUserEmail())) {
            User userMsg = userMapper.queryByUserEmail(userVo.getUserEmail());
            if (userMsg != null) {
                //邮箱已被占用
                if (userVo.getUserEmail().equals(userMsg.getUserEmail()) && userVo.getId() != userMsg.getId()) {
                    return ResponseEntity.errorInfo(UserEnum.$userEmailIsExits);
                }
            }
        }
        //更新用户信息
        User user = new User();
        BeanUtils.copyProperties(userVo, user);
        Integer integer = userMapper.updateUser(user);
        if (1 != integer) {
            return ResponseEntity.errorInfo(UserEnum.$updateUserFail);
        }
        return ResponseEntity.SUCCEED;
    }

    
}
