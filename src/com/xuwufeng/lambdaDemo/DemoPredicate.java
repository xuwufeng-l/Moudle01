package com.xuwufeng.lambdaDemo;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * @author 许武峰
 * @create 2020-01-29-13:00
 *
 */
public class DemoPredicate{
    /*
    方法的参数传递一个包含人员信息的数组
    传递两个predicate接口，对数组信息进行过滤
    满足的存储到ArrayList集合中 并返回
     */
    public static ArrayList<String> filter(String[] arr, Predicate<String> pre1,Predicate<String> pre2){

        ArrayList<String> list = new ArrayList<>();
        //遍历数组获取每一条信息
        for (String s : arr) {
            //使用predicate接口中的test方法
            boolean b = pre1.and(pre2).test(s);
            if(b){
                list.add(s);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        String[] array = {"迪丽热巴，女","古力娜扎，女","马尔扎哈，男","赵丽颖，女"};
        ArrayList<String> list1 = filter(array, (String str) -> {
            return str.split("，")[1].equals("女");
        }, (String str) -> {
            return str.split("，")[0].length() == 4;
        });
        System.out.println(list1.size());
        for (String s : list1) {
            System.out.println("4");
            System.out.println(s);
            System.out.println("2");

        }
        System.out.println("3");
    }


}
