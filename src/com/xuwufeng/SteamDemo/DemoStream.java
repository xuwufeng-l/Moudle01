package com.xuwufeng.SteamDemo;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @author 许武峰
 * @create 2020-01-29-18:52
 */
public class DemoStream {
    public static void main(String[] args) {
        ArrayList<String> one = new ArrayList<>();
        one.add("dlrb");
        one.add("syq");
        one.add("sxh");
        one.add("spt");
        one.add("lz");
        one.add("zz");
        one.add("hqg");
//        ArrayList<String> one1 = new ArrayList<>();
//        for (String name : one) {
//            if(name.length() == 3){
//                one1.add(name);
//            }
//        }
//        ArrayList<String> one2 = new ArrayList<>();
//        for (int i = 0; i < 3; i++) {
//            one2.add(one1.get(i));
//        }
        /*
        改进版
         */
        Stream<String> stream = one.stream().filter((name) -> name.length() == 3).limit(3);




        ArrayList<String> two = new ArrayList<>();
        two.add("glnz");
        two.add("zwj");
        two.add("zly");
        two.add("zs");
        two.add("zta");
        two.add("zeg");
        two.add("glnz");
//        ArrayList<String> two1 = new ArrayList<>();
//        ArrayList<String> two2 = new ArrayList<>();
//        for (String name : two) {
//            if(name.startsWith("z")){
//                two1.add(name);
//            }
//        }
//        for (int i = 2; i < two.size(); i++) {
//            two2.add(two1.get(1));
//        }

        Stream<String> stream1 = two.stream().filter(name -> name.startsWith("z")).skip(2);

        Stream.concat(stream, stream1)
                .map(name->new Person(name)).forEach(name-> System.out.println(name));


//        ArrayList<String> all = new ArrayList<>();
//        all.addAll(two1);
//        all.addAll(two2);
//
//        ArrayList<Person> list = new ArrayList<>();
//        for (String name : all) {
//            list.add(new Person(name));
//
//        }
//
//        for (Person person : list) {
//            System.out.println(person);
//        }


    }
}
