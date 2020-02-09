package com.xuwueng;

import org.junit.Test;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author 许武峰
 * @create 2020-02-05-21:52
 */
public class TestPrepareStatement2 {

    @Test
    public void show(){
        System.out.println("444");
    }


    @Test
    public void testStartment() throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("输入用户名");
        String username = in.next();
        System.out.println("输入密码");
        String password = in.next();

        //连接数据库步骤
//        Properties properties = new Properties();
//        properties.load(new FileInputStream("Moudle02/src/jdbc.properties"));
//        String url = properties.getProperty("url");
//        String user = properties.getProperty("user");
//        String passwd = properties.getProperty("passwd");
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        }catch (Exception e){
//            System.out.println("驱动获取失败");
//        }
//
//        Connection con = null;
//        try {
//            con = DriverManager.getConnection(url,user,passwd);
//        }catch (Exception e){
//            System.out.println("获取连接失败");
//        }
        Connection con = JDBCUtils.getConnect();

        String sql = "select count(*) from testtable where name = '" + username + "' and password = '" + password +"'";

        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        if(resultSet.next()){
            int anInt = resultSet.getInt(1);
            System.out.println(anInt>0?"success":"fail");
        }

//        resultSet.close();
//        statement.close();
//        con.close();
        JDBCUtils.close(resultSet,statement,con);



    }


    public void testpreparedStatement() throws Exception{
        Scanner in = new Scanner(System.in);
        System.out.println("输入用户名");
        String username = in.next();
        System.out.println("输入密码");
        String password = in.next();

        //连接数据库步骤
        Properties properties = new Properties();
        properties.load(new FileInputStream("Moudle02/src/jdbc.properties"));
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String passwd = properties.getProperty("passwd");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (Exception e){
            System.out.println("驱动获取失败");
        }

        Connection con = null;
        try {
            con = DriverManager.getConnection(url,user,passwd);
        }catch (Exception e){
            System.out.println("获取连接失败");
        }


        String sql = "select count(*) from testtable where name = ? and password = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);

        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next()){
            int anInt = resultSet.getInt(1);
            System.out.println(anInt>0?"succ":"fail");
        }
        resultSet.close();
        preparedStatement.close();
        con.close();


    }

    public static void main(String[] args) throws Exception {
        new TestPrepareStatement2().testpreparedStatement();



    }
}
