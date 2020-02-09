package com.xuwueng;

/**
 * @author 许武峰
 * @create 2020-01-20-18:01
 */
public class RunnableMpl implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"创建一个新的线程");
    }
}
