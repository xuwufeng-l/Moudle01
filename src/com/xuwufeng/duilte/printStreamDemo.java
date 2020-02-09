package com.xuwufeng.duilte;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * @author 许武峰
 * @create 2020-01-27-17:35
 */
/*
负责数据输出 不负责读取
不会抛出IO异常

 */
public class printStreamDemo {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream ps = new PrintStream("Moudle02\\print.txt");
        System.setOut(ps);
        System.out.println("@@");
        ps.write(97);
        ps.println(97);

        ps.close();
    }
}
