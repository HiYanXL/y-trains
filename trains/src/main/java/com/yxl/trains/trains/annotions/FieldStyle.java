package com.yxl.trains.trains.annotions;

import java.lang.annotation.*;

@Target({ ElementType.FIELD, ElementType.TYPE })
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldStyle
{
    String value();
}
