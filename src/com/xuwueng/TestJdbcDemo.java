package com.xuwueng;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author 许武峰
 * @create 2020-02-05-19:43
 */
public class TestJdbcDemo {
    public static void main(String[] args) throws SQLException, IOException {
        String address = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone = UTC";
        String user = "root";
        String passwd = "root";

        Properties info = new Properties();
        info.load(new FileInputStream("Moudle02/src/jdbc.properties"));
        String user1 = info.getProperty("user");
        String url = info.getProperty("url");
        String passwd1 = info.getProperty("passwd");



        try {
            //1效率低不采用
            //DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //2
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (Exception e){
            System.out.println("驱动加载失败");
        }

        Connection conn = null;
        try {

            conn = DriverManager.getConnection(url,user1,passwd1);
        }catch (Exception e){
            System.out.println("failure");
        }

//        String sql = "insert into stuinfo (stuname) values('w')";
        Statement statement = conn.createStatement();
        String sql = "select id,stuname,sex,seat from stuinfo";

//        int i = statement.executeUpdate(sql);
//        System.out.println(i>0?"success":"failed");
        ResultSet set = statement.executeQuery(sql);

        while (set.next()){
            int id = set.getInt("id");
            String string = set.getString(2);
            Object sex = set.getObject("sex");
            Object object = set.getObject(4);

            System.out.println(id + " " + string + " " + sex + " " + object);
        }



        set.close();
        statement.close();
        conn.close();


    }
}
