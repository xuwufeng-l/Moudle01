package com.xuwueng;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 许武峰
 * @create 2020-01-22-18:20
 */
public class readerDemo  {
    public static void main(String[] args) throws IOException {



//        int len = 0;
//        while ((len = fileReader.read())!= -1){
//            System.out.print((char)len);
//        }
        try(FileReader fileReader = new FileReader("Moudle02\\c.txt");
            FileWriter fileWriter = new FileWriter("D:\\test.txt");){
            char[] css = {'a','b'};
            char[] cs = new char[1024];
            int len = 0;
            while((len = fileReader.read(cs)) != -1){
                fileWriter.write(cs);
                System.out.print(new String(cs,0,len));
            }
            //fileWriter.flush();
            fileWriter.write("\r\n");
            fileWriter.write("xuwufeng");
            fileWriter.write(css);
        }catch (IOException e){
            System.out.println(e);
        }





    }
}
