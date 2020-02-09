package com.xuwufeng.methodQuote;

/**
 * @author 许武峰
 * @create 2020-01-29-20:11
 */
public class Demo01ObjectMethodReference {
    public static void printString(Printable p){
        p.print("hello");
    }

    public static void main(String[] args) {
        printString((str)->{
            NethodRerObj obj = new NethodRerObj();
            obj.printUpperCaseString(str);
        });
        NethodRerObj obj = new NethodRerObj();
        printString(obj::printUpperCaseString);
    }
}
