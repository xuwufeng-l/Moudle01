package com.xuwufeng1.view;

import com.xuwufeng1.service.AdminService;

import java.util.Scanner;

/**
 * @author 许武峰
 * @create 2020-02-07-18:57
 */
public class studentView {

    AdminService as = new AdminService();
    public static void main(String[] args) {
        new studentView().login();

    }

    public void login (){
        Scanner in = new Scanner(System.in);
        System.out.println("输入用户名");
        String username = in.next();
        System.out.println("输入密码");
        String password = in.next();


        boolean login = as.login(username, password);
        if(login){
            System.out.println("ss");
            System.out.println("zhucaid");
        }else {
            System.out.println("ff");
        }
    }


}
