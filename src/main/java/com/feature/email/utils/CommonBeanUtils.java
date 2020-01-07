package com.feature.email.utils;

import com.feature.email.common.Exception.DIYException;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

//公共处理对象的工具类
public class CommonBeanUtils {

    /**
     * ------------------------------------格式化字符串--------------------------
     **/
    public final static String PATTERN_STRING_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";  //默认使用
    public final static String PATTERN_STRING_YYYY_MM = "yyyy-MM-dd";
    public final static String PATTERN_STRING_YYYY = "yyyy";
    public final static String PATTERN_STRING_MM = "MM";
    public final static String PATTERN_STRING_DD = "dd";

    /**
     * ------------------------------------验证码生成范围------------------------
     **/
    public static final String VERIFY_CODES = "0123456789ABCDEFGHJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public static final int VERIFY_CODES_DEFAULT_LENGTH = 8;

    //将对象中的空字符串转成null
    public final static void convertEmptyStringToNull(Object object) {
        try {
            Field[] fields = getAllFields(object.getClass());
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                //暴力反射
                field.setAccessible(true);
                Object val = field.get(object);
                String type = field.getType().toString();
                if (type.endsWith("String")) {
                    boolean result = null != val && ("".equals(val.toString()) || "NULL".equals(val.toString().toUpperCase()));
                    if (result) {
                        field.set(object, null);
                    }
                }
            }
        } catch (Exception e) {
            throw new DIYException("将对象中的空字符串转成null失败", e);
        }
    }

    /**
     * 通过反射获取类的所有属性、及父类
     *
     * @param clazz
     * @return
     */
    private static Field[] getAllFields(Class<?> clazz) {
        List<Field> fieldList = new ArrayList<>(Arrays.asList(clazz.getDeclaredFields()));
        if (!clazz.getName().toLowerCase().equals("java.lang.object")) {
            fieldList.addAll(Arrays.asList(getAllFields(clazz.getSuperclass())));
        }
        Field[] resFields = new Field[fieldList.size()];
        fieldList.toArray(resFields);
        return resFields;
    }

    /**
     * 判断对象是否为空
     *
     * @param object
     * @return
     */
    public static boolean objectIsEmpty(Object object) {
        return ObjectUtils.isEmpty(object);
    }


    /**
     * 判断对象不为空
     *
     * @param object
     * @return
     */
    public static boolean objectIsNotEmpty(Object object) {
        return !objectIsEmpty(object);
    }


    /**-----------------------------------日期相关处理-----------------------------------------**/
    /**
     * yyyy-MM-dd日期转字符串
     *
     * @param date
     * @return
     */
    public static String localDateFormatterToString(LocalDate date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(PATTERN_STRING_YYYY_MM_DD_HH_MM_SS);
        return date.format(dateTimeFormatter);
    }

    /**
     * yyyy-MM-dd HH:mm:ss日期转字符串
     *
     * @param time
     * @return
     */
    public static String localDataTimeFormatterToString(LocalDateTime time) {
        return time.format(DateTimeFormatter.ofPattern(PATTERN_STRING_YYYY_MM_DD_HH_MM_SS));
    }

    /**
     * 包含时分秒日期字符串转为日期格式
     *
     * @param dateStr
     * @return
     */
    public static Date dateStrFormatterToDateHMS(String dateStr) {
        return DateUtils.localDateTime2Date(
                LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern(PATTERN_STRING_YYYY_MM_DD_HH_MM_SS)));
    }

    /**
     * 不包含时分秒日期转为日期格式
     *
     * @param dateStr
     * @return
     */
    public static Date dateStrFormatterToDateYMD(String dateStr) {
        return DateUtils.localDate2Date(LocalDate.parse(dateStr));
    }

    /**
     * -----------------------------------日期相关处理-------------------------------------------
     **/


    /**
     * 随机生成8位数的验证码
     *
     * @return
     */
    public static String generateVerifyCodeDefaultLength() {
        return generateVerifyCode(VERIFY_CODES_DEFAULT_LENGTH, VERIFY_CODES);
    }

    /**
     * 生成指定长度的验证码
     *
     * @param length
     * @return
     */
    public static String generateVerifyCode(int length) {
        return generateVerifyCode(length, VERIFY_CODES);
    }

    /**
     * 随机生成指定长度的验证码
     *
     * @param verifySize 长度
     * @param sources    指定源
     * @return
     */
    public static String generateVerifyCode(int verifySize, String sources) {
        if (sources == null || sources.length() == 0) {
            sources = VERIFY_CODES;
        }
        int codesLen = sources.length();
        Random rand = new Random(System.currentTimeMillis());
        StringBuilder verifyCode = new StringBuilder(verifySize);
        for (int i = 0; i < verifySize; i++) {
            verifyCode.append(sources.charAt(rand.nextInt(codesLen - 1)));
        }
        return verifyCode.toString();
    }


}
