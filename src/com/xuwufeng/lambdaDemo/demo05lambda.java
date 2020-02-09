package com.xuwufeng.lambdaDemo;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 许武峰
 * @create 2020-01-28-20:25
 */
public class demo05lambda {
    public static Comparator<String> getComparator(){
        //返回接口匿名内部类
//        return new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.length() - o1.length();
//            }
//        }
        //返回函数式接口
        return (String o1,String o2)->o2.length()-o1.length();
    }

    public static void main(String[] args) {
        String[] arr= {"aaaa","bb","eeeee","g"};
        //输出排序前数组
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr,getComparator());
        System.out.println(Arrays.toString(arr));
    }
}
