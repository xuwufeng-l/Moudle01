package com.xuwueng;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author 许武峰
 * @create 2020-02-06-17:15
 * 封装JDBC连接工具类
 *
 * 功能
 * 1 获取连接
 * 2 释放资源
 */
public class JDBCUtils {
    static String user = null;
    static String password = null;
    static String url = null;

    static {
        //注册驱动
        try {
            Properties info = new Properties();
            info.load(new FileInputStream("Moudle02/src/jdbc.properties"));
            user = info.getProperty("user");
            password = info.getProperty("passwd");
            url = info.getProperty("url");
            String driver = info.getProperty("driver");
            Class.forName(driver);
        } catch (Exception e) {
            throw new RuntimeException(e);//编译异常抛运行异常

        }

    }
    /*
    功能 获取可用连接对象
     */

    public static Connection getConnect() throws Exception {

        //获取连接
        Connection con = DriverManager.getConnection(url,user,password);
        return con;

    }

    /**
     * 传入参数关闭对应资源
     *
     * @param set
     * @param statement
     * @param connection
     * @throws SQLException
     */
    public  static void close(ResultSet set, Statement statement,Connection connection) throws SQLException {
        if (set != null){
            set.close();
        }
        if(statement != null){
            statement.close();
        }
        if(connection != null){
            connection.close();
        }

    }



}
