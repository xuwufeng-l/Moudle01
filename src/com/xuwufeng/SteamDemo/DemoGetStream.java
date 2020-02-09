package com.xuwufeng.SteamDemo;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author 许武峰
 * @create 2020-01-29-17:31
 */
public class DemoGetStream {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
        Set<String> set = new HashSet<>();
        Stream<String> stream1 = set.stream();
        Map<String,String> map = new HashMap<>();
        Set<String> keyset = map.keySet();
        Stream<String> stream2 = keyset.stream();
        Collection<String> values = map.values();
        Stream<String> stream3 = values.stream();
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Stream<Map.Entry<String, String>> stream4 = entries.stream();
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 45, 5);


    }


}
