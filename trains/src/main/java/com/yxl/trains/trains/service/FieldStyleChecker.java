package com.yxl.trains.trains.service;

import com.yxl.magicbox.exceptions.YRuntimeException;
import com.yxl.trains.trains.annotions.FieldStyle;
import com.yxl.trains.trains.jobs.FieldStylesJob;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class FieldStyleChecker {


    /**
     * 校验数据属性值
     *
     * @param obj
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    public static void checkAttributeValue(Object obj) {
        if (obj != null) {
            // 得到class
            Class cls = obj.getClass();
            System.out.println("校验对象中参数的数据是否符合要求,校验对象:" + cls.getName());
            // 得到所有属性
            Field[] fields = cls.getDeclaredFields();
            List<Exception> es = new ArrayList<>();
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
                    if (fieldStyle != null) {
                        // 打开私有访问
                        field.setAccessible(true);
                        // 获取属性
                        String name = field.getName();
                        // 获取属性值
                        Object value = field.get(obj);
                        // 获取注解值
                        String style = fieldStyle.value();
                        // 属性值
                        String data = null;
                        // 一个个赋值
                        if (style != null) {
                            String pattern = FieldStylesJob.stylesCache.get(style);
                            if (pattern != null && value != null && value instanceof String) {
                                data = (String) value;
                                if (data != null && !data.matches(pattern)) {
                                    String msg = " 属性" + name + "的值不符合要求格式!";
                                    es.add(new YRuntimeException(msg));
                                    //throw new YRuntimeException(msg);
                                }
                            }
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            if (es != null && !es.isEmpty()) {
                Object[] args = new Object[es.size()];
                for (int i = 0; i < es.size(); i++) {
                    Exception exception = es.get(i);
                    args[i] = exception.getMessage();
                }
                throw new YRuntimeException("对象" + cls.getName() + ":存在不符合格式的属性值!", args);
            }
        }

    }
}