package com.itrus.common.report;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 作者注解
 *
 * @author minghu.zhang
 * @date 11:35 2019/9/4
 **/
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Author {
    /**
     * 作者名称列表
     *
     * @return 作者名称列表
     */
    String[] names() default {};
}
