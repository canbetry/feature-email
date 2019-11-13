package com.feature.email.common.Enum;

public class Constant {
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
}
