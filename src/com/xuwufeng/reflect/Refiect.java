package com.xuwufeng.reflect;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 许武峰
 * @create 2020-01-30-17:58
 */
@pro(className = "com.xuwufeng.reflect.Demo1",methodName = "show")
public class Refiect {
    public static void main(String[] args) throws IOException, ClassNotFoundException,
            IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<Refiect> refiectClass = Refiect.class;
        pro an = refiectClass.getAnnotation(pro.class);
        String className = an.className();
        String methodName = an.methodName();
        System.out.println(className);
        System.out.println(methodName);

        Class<?> cls = Class.forName(className);
        Object obj = cls.newInstance();
        Method clsMethod = cls.getMethod("show");
        clsMethod.invoke(obj);


//        Properties pro = new Properties();
//        ClassLoader classLoader = Refiect.class.getClassLoader();
//        InputStream resourceAsStream = classLoader.getResourceAsStream("pro.properties");
//        pro.load(resourceAsStream);
//
//        String className = pro.getProperty("className");
//        String methodName = pro.getProperty("methodName");
//
//        Class<?> cls = Class.forName(className);
//        Object obj = cls.newInstance();
//        Method method = cls.getMethod(methodName);
//        method.invoke(obj);


    }
}
