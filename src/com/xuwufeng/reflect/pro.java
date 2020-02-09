package com.xuwufeng.reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 许武峰
 * @create 2020-01-30-19:19
 */
/*
描述需要执行的类名 方法名
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface pro {
    String className();
    String methodName();
}
