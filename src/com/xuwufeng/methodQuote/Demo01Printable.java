package com.xuwufeng.methodQuote;

/**
 * @author 许武峰
 * @create 2020-01-29-20:05
 */
public class Demo01Printable {
    public static void printString(Printable p){
        p.print("HollwWorld");
    }

    public static void main(String[] args) {
        printString((s)->{

            System.out.println(s);
        });

        printString(System.out::println);
    }
}
