package com.xuwufeng.lambdaDemo;

import java.util.function.Consumer;

/**
 * @author 许武峰
 * @create 2020-01-28-22:25
 * Consumer接口的默认方法
 * 需要两个consumer接口 把两个接口组合到一起对数据进行消费
 */
public class Demo08AndThen {
    public static void method(String s, Consumer<String> con1, Consumer<String> con2){
        //con1.accept(s);
        //con2.accept(s);
        con1.andThen(con2).accept(s);
    }

    public static void main(String[] args) {
        method("hi",(t)->{
            //sout
            System.out.println(t.toUpperCase());


        },(t)->{
            System.out.println(t.toLowerCase());

        });
    }
}
