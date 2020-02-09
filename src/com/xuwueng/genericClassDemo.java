package com.xuwueng;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 许武峰
 * @create 2020-01-16-10:37
 */
public class genericClassDemo {
    @Test
    public void test4(){
        String[] array = {"qq","ww","ee","rr"};
        String[] strc = func(array, 0, 2);
        System.out.println(Arrays.toString(strc));
    }

    @Test

    public void testNode(){
        Node<String> numberNode = new Node<>("vv");
        Node<Integer> intNode = new Node<>(10);

        System.out.println(numberNode.getData());
        System.out.println(intNode.getData());


    }

    public void test1(){
        List<String> list = new ArrayList();
        list.add("vv");
        list.add("ww");
//        list.add(10);
//        list.add(new Object());

        for (int i = 0; i < list.size() ; i++) {

        }


    }

    public static <T> T[] func(T[] array,int i, int t){
        T temp = array[i];
        array[i] = array[t];
        array[t] = temp;
        return array;
    }


}
