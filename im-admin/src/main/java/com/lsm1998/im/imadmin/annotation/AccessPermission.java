package com.lsm1998.im.imadmin.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;

@Documented
@java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE, ElementType.METHOD})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface AccessPermission
{
    String value() default "";
}
