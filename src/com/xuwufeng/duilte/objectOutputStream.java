package com.xuwufeng.duilte;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author 许武峰
 * @create 2020-01-27-14:44
 */
public class objectOutputStream  {
    public static void main(String[] args) throws IOException {

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Moudle02\\person.txt"));
        oos.writeObject(new Person("11",13));
        oos.close();




    }
}
