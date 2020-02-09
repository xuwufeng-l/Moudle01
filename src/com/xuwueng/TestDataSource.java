package com.xuwueng;

/**
 * @author 许武峰
 * @create 2020-02-06-21:01
 */

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * druid
 */
public class TestDataSource {

    @Test
    public void testDataSource() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("Moudle02/src/druid.properties"));
        //创建指定数量连接池
        DataSource ds = DruidDataSourceFactory.createDataSource(properties);

        Connection con = null;
        con = ds.getConnection();

//        try {
//            con = ds.getConnection();
//
//        }catch(Exception e){
//            System.out.println(2);
//        }


        System.out.println("success");
        con.close();
    }




    public static void main(String[] args) throws Exception {
        new TestDataSource().testDataSource();
    }

}
