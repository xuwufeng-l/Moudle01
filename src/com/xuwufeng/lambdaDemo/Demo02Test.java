package com.xuwufeng.lambdaDemo;

import java.util.function.Supplier;

/**
 * @author 许武峰
 * @create 2020-01-28-20:53
 */
public class Demo02Test {
    public static int getMax(Supplier<Integer> sup){
        return sup.get();
    }

    public static void main(String[] args) {
        int[] array = {100,3,44,56,88,999};
        int a = getMax(()->{
            int temp = array[0];
            for (int i : array) {
                if(i >= temp){
                    temp = i;
                }
            }
            return temp;
        });
        System.out.println(a);
    }
}
