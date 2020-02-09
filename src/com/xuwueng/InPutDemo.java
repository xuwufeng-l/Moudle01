package com.xuwueng;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 许武峰
 * @create 2020-01-22-15:27
 */
public class InPutDemo {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("C:\\Users\\dell\\Desktop\\毕业设计文件\\图片1.jpg");
        FileOutputStream fos = new FileOutputStream("D:\\testdemo.jpg");
//        int read = fis.read();
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fis.read(bytes)) != -1){
            fos.write(bytes,0,len);
        }
        fos.close();
        fis.close();

    }
}
