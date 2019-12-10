package com.feature.email.common.Enum;


/**
 * 常量池
 */
public class Constant {
    //常用整数
    public final static Integer COMMON_NUMBER_ZERO = 0;
    public final static Integer COMMON_NUMBER_ONE = 1;
    public final static Integer COMMON_NUMBER_TWO = 2;
    public final static Integer COMMON_NUMBER_THREE = 3;
    public final static Integer COMMON_NUMBER_FOUR = 4;
    public final static Integer COMMON_NUMBER_FIVE = 5;
    public final static Integer COMMON_NUMBER_SIX = 6;
    public final static Integer COMMON_NUMBER_SEVEN = 7;
    public final static Integer COMMON_NUMBER_MB = 1024;


    //统一信息识别码
    public final static Integer SUCCESS_CODE = 200;
    public final static Integer ERROR_CODE = 1;
    public final static String SUCCESS_MESSAGE = "成功";
    public final static String ERROR_MESSAGE = "失败";
    public final static String STATUS = "status";
    public final static String MESSAGE = "message";
    public final static String CONTENT = "content";

    //用户类型
    public final static char USER_TYPE_MANAGER = '1';
    public final static char USER_TYPE_COMMON = '2';

    //逻辑删除标志
    public final static char IS_DELETED = '1';
    public final static char NOT_DELETED = '0';

    //session参数
    public final static String SESSION_INFO_PARAMS = "user_session_info";
    public final static String SESSION_INFO_PARAMS_CODE_EMAIL = "EMAIL_VERIFY_CODE";


    //系统固有属性
    public final static String SYSTEM_PROPERTY = "os.name";
    public final static String WIN_SYSTEM_VERSION_LOWER_CASE = "win";

    //RSA
    public final static String STRING_RSA = "RSA";

    //rsa路径
    public final static String WIN_RSA_PRIVATE_KEY_PATH = "\\rsaPriKey.key";
    public final static String LINUX_RSA_PRIVATE_KEY_PATH = "/rsaPriKey.key";

    public final static String WIN_RSA_PUBLIC_KEY_PATH = "\\rsaPubKey.key";
    public final static String LINUX_RSA_PUBLIC_KEY_PATH = "/rsaPubKey.key";

    //系统编码
    public final static String CODING_TYPE_UTF8 = "UTF-8";


    //邮件验证码默认主题
    public final static String EMAIL_VERIFY_CODE_TITLE_DEFAULT = "邮件验证码";
}
