package com.xuwufeng.lambdaDemo;

import java.util.function.Supplier;

/**
 * @author 许武峰
 * @create 2020-01-28-20:47
 * supplier接口称为生产型接口，指定接口泛型是什么泛型 那么接口中的get方法就会生产什么类型数据
 */
public class Demo06Supplier {
    //定义一个supplier接口 泛型执行String get就会返回一个String
    public static String getString(Supplier<String> sup){
        return sup.get();
    }

    public static void main(String[] args) {
        String s = getString(()->{
            return "hg";
        });

        System.out.println(s);
    }


}
