package com.lsm1998.im.common.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;

@Documented
@java.lang.annotation.Target({ElementType.TYPE, ElementType.METHOD})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface AccessPermission
{
    String value() default "";
}
