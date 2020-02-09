package com.xuwufeng.methodQuote;

/**
 * @author 许武峰
 * @create 2020-01-29-20:18
 */
public class Demo01StaticMethodReference {
    public static int method(int num,Calcable c){
        return c.calAbs(num);
    }
    public static void main(String[] args) {
        int number = method(-1, (n) -> {
            return Math.abs(n);
        });
        System.out.println(number);

        int num2 = method(-1, Math::abs);
        System.out.println(num2);

    }
}
