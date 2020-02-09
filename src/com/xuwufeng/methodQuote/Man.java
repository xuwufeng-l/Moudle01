package com.xuwufeng.methodQuote;

/**
 * @author 许武峰
 * @create 2020-01-29-20:28
 */
public class Man extends Human {
    @Override
    public void sayHello() {
        System.out.println("hello iam man");
    }
    public void method(Greetable g){
        g.greet();
    }

    public void show(){
//        method(()->{
//            Human h = new Human();
//            h.sayHello();
//        });

        /*
        super引用父类成员方法
         */
        method(super::sayHello);
        method(this::sayHello);
    }

    public static void main(String[] args) {
        new Man().show();

    }
}
