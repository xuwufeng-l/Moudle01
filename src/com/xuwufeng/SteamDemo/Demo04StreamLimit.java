package com.xuwufeng.SteamDemo;

import java.util.stream.Stream;

/**
 * @author 许武峰
 * @create 2020-01-29-18:34
 */
public class Demo04StreamLimit {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("myy", "xyy", "htl", "lyy");
//        Stream<String> stream1 = stream.limit(3);
//        stream1.forEach((name)->{
//            System.out.println(name);
//        });

        Stream<String> stream2 = stream.skip(2);
        stream2.forEach((name)->{
            System.out.println(name);
        });
    }

}
