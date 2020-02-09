package com.xuwufeng.duilte;

import java.io.*;
import java.util.ArrayList;

/**
 * @author 许武峰
 * @create 2020-01-27-17:23
 */
public class Demo03Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("zs",18));
        list.add(new Person("ls",19));
        list.add(new Person("ww",20));
        //创建一个序列化流objecOutputStream对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Moudle02\\list.txt"));
        oos.writeObject(list);//使用方法对集合进行序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Moudle02\\list.txt"));
        Object o = ois.readObject();
        ArrayList<Person> list2 = (ArrayList<Person>)o;
        for (Person person : list2) {
            System.out.println(person);
            
        }
        ois.close();
        oos.close();


    }
}
