package com.xuwufeng.duilte;

import java.io.Serializable;

/**
 * @author 许武峰
 * @create 2020-01-27-14:45
 */
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    /*
    transient瞬态关键字 与static功能相似 但是不预先读入内存
     */

    private String name;
    private  int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {

        return name;
    }

    public int getAge() {
        return age;
    }
}
