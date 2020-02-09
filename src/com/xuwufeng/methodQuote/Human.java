package com.xuwufeng.methodQuote;

/**
 * @author 许武峰
 * @create 2020-01-29-20:27
 */
/*
定义父类
 */
public class Human {
    private String name;

    private int age;

    public int a;

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", a=" + a +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Human() {

    }

    public Human(String name, int age) {

        this.name = name;
        this.age = age;
    }

    public void sayHello(){
        System.out.println("Hello i am human");
    }
}
