package com.xuwufeng.lambdaDemo;

import java.util.function.Function;

/**
 * @author 许武峰
 * @create 2020-01-29-16:40
 * 字符串截取数字部分，得到字符串 Function<str,str></str,str>
 * 上一步的字符串转换为int类型Function<str,int
 * 上一步int数字累加100 function<int,int
 */
public class DemiFunction {
    public static int change(String s, Function<String,String> fun1,Function<String,Integer> fun2,
                             Function<Integer,Integer> fun3){
        Integer ss = fun1.andThen(fun2).andThen(fun3).apply(s);
        System.out.println(ss);
        return ss;
    }

    public static void main(String[] args) {
        String str = "zly,88";
        int change = change(str, (s) -> {
            return s.split(",")[1];
        }, (s) -> {
            return Integer.parseInt(s);
        }, (i) -> {
            return i + 100;
        });
        change = change("zs,99", s -> s.split(",")[1], s -> Integer.parseInt(s), i -> i + 100);
        System.out.println(change + 1);


    }

}
