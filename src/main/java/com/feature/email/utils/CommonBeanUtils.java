package com.feature.email.utils;

import com.feature.email.common.Exception.DIYException;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//公共处理对象的工具类
public class CommonBeanUtils {

    //将对象中的空字符串转成null
    public final static void convertEmptyStringToNull(Object object) {
        try {
            Field[] fields = getAllFields(object.getClass());
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                field.setAccessible(true);  //暴力反射
                Object val = field.get(object);
                String type = field.getType().toString();
                if (type.endsWith("String")) {
                    if (null != val && ("".equals(val.toString()) || "NULL".equals(val.toString().toUpperCase()))) {
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
}
