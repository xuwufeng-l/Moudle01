package com.xuwufeng.lambdaDemo;

import java.util.function.Consumer;

/**
 * @author 许武峰
 * @create 2020-01-28-21:00
 * 消费型接口泛型指定什么类型 就可以使用accept方法消费什么类型数据
 * 具体使用需要自定义
 */
public class Demo07Consumer {
    /*
    定义一个方法
    方法传递一个字符串的名字
    方法的参数传递Consumer接口 泛型使用String
    可以使用Consumer 接口消费字符串的名字
     */
    public static void method(String name, Consumer<String> con){
        con.accept(name);
    }

    public static void main(String[] args) {
        method("zbkm",(String name)->{
                       String reName = new StringBuffer(name).reverse().toString();
            System.out.println(reName);

        });
    }
}
