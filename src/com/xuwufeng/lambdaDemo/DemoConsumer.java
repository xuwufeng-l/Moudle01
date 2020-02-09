package com.xuwufeng.lambdaDemo;

import java.util.function.Consumer;

/**
 * @author 许武峰
 * @create 2020-01-28-22:33
 */
public class DemoConsumer {
    //定义方法参数传递String类型数组和两个consumer接口，泛型使用String
    public static void printInfo(String[] arr, Consumer<String> con1,Consumer<String> con2){
        //遍历数组
        for (String message : arr) {
            //使用andthen 连接
            con1.andThen(con2).accept(message);
        }

    }

    public static void main(String[] args) {
        String[] arr = {"迪丽热巴，女","古力娜扎，女","马尔扎哈，男"};

        printInfo(arr,(message)->{
            String name = message.split("，")[0];
            System.out.print("姓名：" + name);
        },(message)->{
            String age = message.split("，")[1];
            System.out.println("。年龄："+ age);
        });
    }
}
