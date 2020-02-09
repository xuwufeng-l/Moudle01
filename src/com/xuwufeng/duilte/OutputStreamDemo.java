package com.xuwufeng.duilte;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 许武峰
 * @create 2020-01-22-14:56
 */

/*

 */
public class OutputStreamDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("D:\\my01.txt",true);
//        fos.write(97);
//        fos.write(222);

        //byte[] bytes = {65,66,67,68};
        String str = "hyiersan";
        for (int i = 0; i < 10; i++) {
            //fos.write("\n".getBytes());
           // fos.write(str.getBytes());
        }


        fos.close();






    }
}
