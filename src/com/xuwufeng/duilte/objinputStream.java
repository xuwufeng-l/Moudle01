package com.xuwufeng.duilte;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author 许武峰
 * @create 2020-01-27-14:54
 */
public class objinputStream  {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Moudle02\\person.txt"));
        Object o = ois.readObject();
        Person p = (Person)o;
        ois.close();
        System.out.println(p);
        System.out.println(p.getName() +"="+p.getAge());


    }
}
