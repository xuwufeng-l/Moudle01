package com.xuwufeng.SteamDemo;

/**
 * @author 许武峰
 * @create 2020-01-29-19:09
 */
public class Person {
    private String name;

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public Person(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
