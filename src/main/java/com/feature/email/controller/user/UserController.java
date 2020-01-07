package com.feature.email.controller.user;

import com.feature.email.common.Enum.BaseErrorMsg;
import com.feature.email.common.Enum.Constant;
import com.feature.email.common.Enum.UserEnum;
import com.feature.email.common.response.ResponseEntity;
import com.feature.email.controller.BaseController;
import com.feature.email.entityVo.user.UserPwdVo;
import com.feature.email.entityVo.user.UserVo;
import com.feature.email.service.user.UserService;
import com.feature.email.utils.CommonBeanUtils;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;


/**
 * @description: UserController <br>
 * @date: 2020/1/7 10:46 <br>
 * @author: luoyl <br>
 * @version: 1.0 <br>
 */
@RestController
@Log4j2
@Api(description = "用户相关接口")
@RequestMapping("/user")
@SuppressWarnings("all")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @ApiOperation("注册用户接口")
    @PostMapping("/register")
    public ResponseEntity<UserVo> saveUser(@RequestBody UserVo userVo) {
        CommonBeanUtils.convertEmptyStringToNull(userVo);
        return userService.saveUser(userVo);
    }

    @ApiOperation("用户登录接口")
    @GetMapping("/login")
    public ResponseEntity<UserVo> userLogin(String userName, String userPassword, HttpServletRequest request) {
        UserVo userVo = new UserVo();
        userVo.setUserName(userName);
        userVo.setUserPassword(userPassword);
        return userService.userLogin(userVo, request);
    }

    @ApiOperation("用户登出接口")
    @GetMapping("/logout")
    public ResponseEntity userLogout(HttpServletRequest request) {
        return userService.userLogout(request);
    }

    @ApiOperation("更新用户信息")
    @PostMapping("/update")
    public ResponseEntity updateUser(@RequestBody UserVo userVo) {
        CommonBeanUtils.convertEmptyStringToNull(userVo);
        return userService.updateUser(userVo);
    }

    @ApiOperation("修改用户密码接口")
    @PostMapping("/updatePwd")
    public ResponseEntity updatePwd(@RequestBody UserPwdVo userPwdVo) {
        CommonBeanUtils.convertEmptyStringToNull(userPwdVo);
        return userService.updatePwd(userPwdVo);
    }

    @ApiOperation("二维码登录获取二维码")
    @GetMapping("/getQRcode")
    public ResponseEntity getQRCode(HttpServletRequest request, HttpServletResponse response) {
        try {
            //二维码中包含的信息
            String content = "";
            Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
            // 指定编码格式
            hints.put(EncodeHintType.CHARACTER_SET, Constant.CODING_TYPE_UTF8);
            // 指定纠错级别(L--7%,M--15%,Q--25%,H--30%)
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            // 编码内容,编码类型(这里指定为二维码),生成图片宽度,生成图片高度,设置参数
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, 200, 200, hints);
            //设置请求头
            response.setHeader(Constant.REQUEST_HEADER_CONTENT_TYPE, Constant.CONTENT_TYPE_OCTET_STREAM);
            response.setHeader(Constant.REQUEST_HEADER_CONTENT_DISPOSITION, Constant.DISPOSITION_ATTACHMENT + "登录二维码.png");
            OutputStream outputStream = response.getOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, Constant.IMAGE_TYPE_PNG, outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (WriterException e) {
            log.error(BaseErrorMsg.systemException, e);
            return ResponseEntity.errorInfo(UserEnum.$systemException);
        } catch (IOException e) {
            log.error(BaseErrorMsg.systemException, e);
            return ResponseEntity.errorInfo(UserEnum.$systemException);
        }
        return ResponseEntity.SUCCEED;
    }

}
