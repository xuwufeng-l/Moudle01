package com.xuwufeng.SteamDemo;

import java.util.stream.Stream;

/**
 * @author 许武峰
 * @create 2020-01-29-18:11
 * stream中常用方法foreach 该方法接收一个consumer接口函数 会将每一个元素交给函数进行处理
 * consumer接口一个消费型函数接口可以传递lambda 消费数据
 *  终结方法
 */
public class Demo02StreamForEach {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("zs", "ls", "ww", "zl", "tq");
        stringStream.forEach((name)->{
            System.out.println(name);
        });

        Stream<String> stream = Stream.of("zsf", "zcs", "zm", "zzr", "zwj");
        Stream<String> stringStream1 = stream.filter((name) -> {
            return name.startsWith("z");
        });
        stringStream1.forEach((name)->{
            System.out.print(name+" ");
        });


    }
}
