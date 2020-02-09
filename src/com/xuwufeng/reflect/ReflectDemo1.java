package com.xuwufeng.reflect;

import com.xuwufeng.methodQuote.Human;

import java.lang.reflect.Method;

/**
 * @author 许武峰
 * @create 2020-01-30-16:52
 */
public class ReflectDemo1 {
    public static void main(String[] args) throws Exception {
        Class cls = Class.forName("com.xuwufeng.methodQuote.Human");
        System.out.println(cls);
        //2.
        Class cls1 = Human.class;
        System.out.println(cls1);
        Method[] methods = cls1.getMethods();
        for (Method method : methods) {

            System.out.println(method);
        }

        Method nane1 = cls1.getMethod("sayHello");
        Human hu = new Human();
        nane1.invoke(hu);

        Method name2 = cls1.getMethod("setAge", int.class);
        name2.invoke(hu,33);
        System.out.println(hu);



//        Constructor constructor = cls1.getConstructor(String.class, int.class);
//        System.out.println(constructor);
//        Object zs = constructor.newInstance("zs", 23);
//        System.out.println(zs);
//




//        Field[] fields = cls1.getFields();//获取public
//        for (Field field : fields) {
//            System.out.println(field);
//        }
//
//        Field name = cls1.getField("a");//获取私有方法
//        Human hu = new Human();
//        Object value = name.get(hu);
//        System.out.println(value);
//        name.set(hu,33);
//        System.out.println(hu);
//        System.out.println("---------------------");
//
//        Field[] declaredFields = cls1.getDeclaredFields();
//        for (Field declaredField : declaredFields) {
//            System.out.println(declaredField);
//        }
//
//        Field name1 = cls1.getDeclaredField("name");//使用私有的修饰符修饰的域时要忽略安全权限
//        name1.setAccessible(true);//暴力反射
//        Object o = name1.get(hu);
//        System.out.println(o);
//        name1.set(hu,"str");
//        System.out.println(hu);


        //3.
        Human h = new Human();
        Class cls2 = h.getClass();
        System.out.println(cls2);

        System.out.println(cls == cls1&& cls1 == cls2);
    }
}






