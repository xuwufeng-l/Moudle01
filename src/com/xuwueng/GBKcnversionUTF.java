package com.xuwueng;

import java.io.*;

/**
 * @author 许武峰
 * @create 2020-01-27-14:09
 */
public class GBKcnversionUTF {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("Moudle02\\GBK编码.txt"),"gbk");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("Moudle02\\GBK编码01.txt"),"utf-8");
        int len = 0;
        while((len = isr.read()) != -1){
            osw.write(len);
        }
        osw.close();
        isr.close();



    }


}
