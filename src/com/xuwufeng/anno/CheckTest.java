package com.xuwufeng.anno;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author 许武峰
 * @create 2020-01-30-19:47
 */
public class CheckTest {
    public static void main(String[] args) throws IOException {

        Calcuator c = new Calcuator();

        Class cls = c.getClass();

        Method[] methods = cls.getMethods();

        int num = 0;
        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));

        for (Method method : methods) {

            if(method.isAnnotationPresent(Check.class)){
                try {
                    method.invoke(c);
                } catch (Exception e) {
                    num++;
                    bw.write(method.getName() + "方法出现异常");
                    bw.newLine();
                    bw.write("异常名称"+e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常原因"+e.getCause().getMessage());
                    bw.newLine();
                    bw.write("-------------");
                    bw.newLine();
                }
            }
        }
        bw.write("出现" + num + " 次异常");
        bw.flush();
        bw.close();

    }
}
