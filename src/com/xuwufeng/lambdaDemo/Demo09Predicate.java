package com.xuwufeng.lambdaDemo;

import java.util.function.Predicate;

/**
 * @author 许武峰
 * @create 2020-01-28-22:51
 * 作用：对某种数据类型进行判断 返回一个布尔值
 * 用Test方法哟用来对指定类型数据进行判断
 */
public class Demo09Predicate {
    /*
    定义一个方法
    参数传递一个String类型的字符串
    传递一个Predicate接口泛型使用String
    使用predicate中的test对字符串进行判断 把判断结果返回
     */
    public static boolean checkString(String s, Predicate<String> pre){
        return pre.test(s);
    }

    public static void main(String[] args) {
//        String s = "abcde";
//        boolean b = checkString(s, (str) -> {
//            //对传递字符串长度判断是否大于5
//            return str.length()>5;
//        });
//        System.out.println(b);
        String s = "abcdeff";
        boolean b1 = checkString(s, (str) -> {
            return str.length() > 5;
        });
        System.out.println(b1);
        boolean b = checkString1(s, (str) -> {
            return str.length() > 5;
        });
        System.out.println(b);
//        System.out.println(b)

    }

    /*
    predicate 中的and方法 表示并且关系，也可以连接两个判断条件
     */

//    public static boolean checkString(String s,Predicate<String> pre1,Predicate<String> pre2){
////        return pre1.test(s)&&pre2.test(s);
//        return pre1.and(pre2).test(s);
//    }

    /*
    predicatae or
     */
//    public static boolean checkString(String s,Predicate<String> pre1,Predicate<String> pre2){
//        return pre1.or(pre2).test(s);
//    }

    /*
    nageta predicate方法中的取反操作
     */
    public static boolean checkString1(String s,Predicate<String> pre){
        return pre.negate().test(s);
    }


}
