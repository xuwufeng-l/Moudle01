package com.xuwufeng1.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author 许武峰
 * @create 2020-02-06-22:05
 */
public class JDBCUtilsByDriud {
    static  DataSource ds ;
    static {

        //创建指定数量连接池
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("Moudle02/src/druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnect() throws Exception {


        Connection con = null;
        con = ds.getConnection();

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
    public  static void close(ResultSet set, Statement statement, Connection connection) throws SQLException {
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

    public static void main(String[] args) throws Exception {
        getConnect();
    }

}
