package com.xuwueng;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * @author 许武峰
 * @create 2020-01-22-21:37
 */
public class PropertiesDemo01  {
    public static void main(String[] args) throws IOException {
       // show01();
        //show02();
        show03();
    }

    private static void show03() throws IOException {
        Properties prop = new Properties();
        prop.load(new FileReader("D:\\test03.txt"));
        Set<String> set = prop.stringPropertyNames();
        for (String key : set) {
            String vlaue = prop.getProperty(key);
            System.out.println(key+"="+vlaue);

        }


    }

    private static void show02() throws IOException {
        Properties prop = new Properties();

        prop.setProperty("张靓颖","168");
        prop.setProperty("dlrb","165");
        prop.setProperty("glnz","160");




//        FileWriter fw = new FileWriter("D:\\test03.txt");
//
//        prop.store(fw,"save data");
//
//        fw.close();
        prop.store(new FileOutputStream("D:\\test03.txt"),"");
    }

    /*
    使用properties集合存储数据，便利properties集合中的数据
    pro集合是一个双列集合，key value都是字符串
     */
    private static void show01() {

        Properties prop = new Properties();

        prop.setProperty("zly","168");
        prop.setProperty("dlrb","165");
        prop.setProperty("glnz","160");
        //使用stringpropertiesname把properties集合中的键取出，存储到一个Set集合中
        Set<String> set = prop.stringPropertyNames();
        //遍历Set集合 取出properties集合的没一个键
        for (String key : set) {
            System.out.println(key + "=" + prop.getProperty(key));
        }

    }
}
