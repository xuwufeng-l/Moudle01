package com.xuwueng;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 许武峰
 * @create 2020-02-06-21:55
 */
public class testC3p0 {

    public void testC3p0() throws Exception {
        ComboPooledDataSource cpds1 = new ComboPooledDataSource();
        cpds1.setDriverClass("com.mysql.cj.jdbc.Driver");
        cpds1.setJdbcUrl("jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC&rewriteBatchStatements=true");
        cpds1.setUser("root");
        cpds1.setPassword("root");
        cpds1.setInitialPoolSize(10);
        cpds1.setMaxPoolSize(50);


        Connection connection = cpds1.getConnection();
        System.out.println("s");

        connection.close();

    }


    public void testC3p02() throws SQLException {
        ComboPooledDataSource cpds = new ComboPooledDataSource("hello");
        Connection connection = cpds.getConnection();
        System.out.println("ss");
        connection.close();

    }

    public static void main(String[] args) throws Exception {
        new testC3p0().testC3p0();
    }
}
