package com.xuwufeng.SteamDemo;

import java.util.stream.Stream;

/**
 * @author 许武峰
 * @create 2020-01-29-18:50
 */
public class Demo05StreamConcat {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("zwl");
        Stream<String> stream1 = Stream.of("zzl");
        Stream<String> stream2 = Stream.concat(stream, stream1);
        stream2.forEach((name)->{
            System.out.println(name        );
        });
    }
}
