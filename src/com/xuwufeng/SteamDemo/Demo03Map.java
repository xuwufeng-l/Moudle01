package com.xuwufeng.SteamDemo;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @author 许武峰
 * @create 2020-01-29-18:24
 *
 */
public class Demo03Map {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("1", "2", "3", "4");
        //使用map 把字符串类型数据转换为integer
        Stream<Integer> stream1 = stream.map((str) -> {
            return Integer.parseInt(str);
        });
        stream1.forEach((i)->
        {
            System.out.println(i);
        });

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        long count = list.stream().count();
        System.out.println(count);

    }
}
