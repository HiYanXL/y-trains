package com.yxl.trains.trains.dto.req;

import java.lang.reflect.Field;

public class Req {
    private static int counter = 0;

    @Override
    public String toString() {
        counter++;
        return this.Obj2String(this);
    }

    public String Obj2String(Object object) {
        if (counter > 1) {
            counter = 0;
            return super.toString();
        }
        Class cls = object.getClass();
        Field[] fields = cls.getDeclaredFields();
        StringBuffer sb = new StringBuffer(object.toString()).append(" ");
        for (int i = 0; i < fields.length; i++) {
            try {
                Field field = fields[i];
                field.setAccessible(true);
                String name = field.getName();
                Object value = field.get(object);
                sb.append(name).append(":").append(value);
                if (i < fields.length - 1) {
                    sb.append(",");
                } else {
                    sb.append(".");
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
