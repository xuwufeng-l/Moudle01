package com.xuwufeng.anno;

/**
 * @author 许武峰
 * @create 2020-01-30-19:44
 */
public class Calcuator {
@Check
    public void add(){
        String str = null;
        str.toString();
        System.out.println("1 + 0 =" + (1 +  0));
    }
@Check
    public void sub(){
        System.out.println("1 - 0 =" + (1 - 0));
    }
@Check
    public void mul(){
        System.out.println("1 * 0 =" + (1 * 0));
    }
@Check
    public void div(){
        System.out.println("1 / 0 =" + (1 / 0));
    }

    public void show(){
        System.out.println("1 + 0 =" + (1 +  0));
    }

}
