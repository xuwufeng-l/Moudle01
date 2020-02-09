package com.xuwueng;

import java.util.Arrays;

/**
 * @author 许武峰
 * @create 2020-01-20-17:58
 */
public class DemoThreadPool {
    public static void main(String[] args) {
//        ExecutorService es = Executors.newFixedThreadPool(2);
//        es.submit(new RunnableMpl());
//        es.submit(new RunnableMpl());
//        es.submit(new RunnableMpl());
          //创建runnable接口对象
        //RunnableMpl run = new RunnableMpl();
        //创建thread类对象
//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName()+"创建一个线程-02");
//            }
//        });
//
//        t.start();
          Thread t = new Thread(() -> System.out.println(Thread.currentThread().getName()+"创建新线程 - 03"));
          t.start();

          Person[] arr = {
                new Person("kkw",44),
                new Person("aa",15),
                new Person("tt",43),
                new Person("mm",16)
          };

//        Arrays.sort(arr, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getAge() - o2.getAge();
//            }
//        });

        Arrays.sort(arr,(Person o1,Person o2) ->

             o1.getAge() - o2.getAge()
        );

        for (Person p : arr) {
            System.out.println(p);

        }
    }
}
