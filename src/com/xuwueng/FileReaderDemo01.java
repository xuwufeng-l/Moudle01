package com.xuwueng;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 许武峰
 * @create 2020-01-27-13:20
 */
public class FileReaderDemo01 {
    public static void main(String[] args) throws IOException {
//        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("Moudle02\\GBK编码.txt"),"GBK");
//        osw.write("你好");
//        osw.flush();
//        osw.close();
        /*
        inputstreamReader
         */
        InputStreamReader isr = new InputStreamReader(new FileInputStream("Moudle02\\GBK编码.txt"),"GBK");
        int len = 0;
        while ((len = isr.read()) != -1){
            System.out.println((char)len);
        }
        isr.close();


    }
}
