package com.xuwufeng.lambdaDemo;

import java.util.function.Function;

/**
 * @author 许武峰
 * @create 2020-01-29-16:22
 * 定义一个方法
 * 方法参数传递一个字符串类型整数
 * 方法参数传递一个FUN窗体on接口 泛型使用<String  ,Integer></>
 * 使用Function接口中的方法apply 把字符串类型的整数转换为integer
 */
public class Demo10Function {
    public static void change(String s, Function<String,Integer> fun){
        Integer in = fun.apply(s);
        System.out.println(in);
    }

    /*
    functioo 接口的andthen 组合操作
    两个Function接口 一个FUn<String Integer>
    另一个fun<integer,String>
     */
    public static void change1(String s,Function<String,Integer> fun1,Function<Integer,String> fun2){
        String ss = fun1.andThen(fun2).apply(s);
        System.out.println(ss);
    }

    public static void main(String[] args) {
        String s = "1234";
//        change(s,(str)->{
//            return Integer.parseInt(str);
//        });
        change1(s,(str)->{
            return Integer.parseInt(str)+10;
        },(i)->{
            return i+"";
        });

        change1("123445",str->Integer.parseInt(str)+10,i->i+"");
    }

}
