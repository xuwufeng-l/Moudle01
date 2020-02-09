package com.xuwufeng.lambdaDemo;

/**
 * @author 许武峰
 * @create 2020-01-28-20:21
 */
public class Demo04Runnable {
    public static void startThread(Runnable task){
        new Thread(task).start();
    }

    public static void main(String[] args) {
        startThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"start");
            }
        });

        startThread(()->{
            System.out.println(Thread.currentThread().getName()+"start");
        });
    }
}
