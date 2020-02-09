package com.xuwufeng.SteamDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 许武峰
 * @create 2020-01-29-16:55
 */
public class DemoForEach {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("zwj");
        list.add("zzr");
        list.add("zm");
        list.add("zq");
        list.add("zsf");

        /*
        流操作 改进版
         */
        list.stream().filter(name->name.startsWith("z")).filter(name->name.length() == 3).forEach(name-> System.out.println(name));
        System.out.println("-------------------------------");


        //对元素进行过滤 以张开头加入集合
        List<String> list1 = new ArrayList<>();
        for (String s : list) {
            if(s.startsWith("z")){
                list1.add(s);
            }
        }

        //长度为3
        List<String> shortList = new ArrayList<>();
        for (String s : list1) {
            if(s.length() == 3){
                shortList.add(s);
            }

        }

        for (String s : shortList) {
            System.out.println(s);

        }
    }
}
