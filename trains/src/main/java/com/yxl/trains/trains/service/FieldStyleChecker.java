package com.yxl.trains.trains.service;

import com.yxl.magicbox.exceptions.YRuntimeException;
import com.yxl.magicbox.utils.StringUtils;
import com.yxl.trains.trains.annotions.FieldStyle;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class FieldStyleChecker {


    /**
     * 校验数据属性值
     *
     * @param obj
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    public static void checkAttributeValue(Object obj) throws Exception {
        if (null != obj) {
            // 得到class
            Class cls = obj.getClass();
            System.out.println("校验对象中参数的数据长度是否符合要求,校验对象:" + cls.getName());
            // 得到所有属性
            Field[] fields = cls.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {// 遍历
                try {
                    // 得到属性
                    Field field = fields[i];
                    Annotation[] annotations = field.getAnnotations();
                    FieldStyle fieldStyle = null;
                    for (Annotation annotation : annotations) {
                        if (annotation instanceof FieldStyle)
                            fieldStyle = (FieldStyle) annotation;
                    }

                    // 校验注解值
                    if (null != fieldStyle) {
                        // 打开私有访问
                        field.setAccessible(true);
                        // 获取属性
                        String name = field.getName();
                        // 获取属性值
                        Object value = field.get(obj);
                        // 获取注解值
                        String pattern = fieldStyle.value();
                        // 属性值
                        String data = null;
                        // 一个个赋值
                        if (null != value && value instanceof String) {
                            data = (String) value;
                            if (StringUtils.isNotEmpty(data) && !data.matches(pattern)) {
                                String msg = "对象" + cls.getName() + ": 属性" + name + "的值不符合要求格式!";
                                throw new YRuntimeException(msg);
                            }
                        }


                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}