package com.xuwueng;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 许武峰
 * @create 2020-01-16-10:47
 */
public class Node<T> {

    private T data;

    public Node(){}

    public Node(T data){

        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     *
     * @param array
     * @param i
     * @param t
     * @param <T>
     */
    public static <T> T[] func(T[] array,int i,int t){

        T temp = array[i];
        array[i] = array[t];
        array[t] = temp;
        return array;
    }

    @Test
    public void test1(){
        String[] array = {"bb","a","qq","ee"};
        String[] fun = func(array, 0, 1);
        System.out.println(Arrays.toString(fun));

    }

}
