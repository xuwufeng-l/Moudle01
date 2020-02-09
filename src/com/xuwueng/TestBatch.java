package com.xuwueng;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author 许武峰
 * @create 2020-02-06-18:31
 * 向admin插入50000数据
 */
public class TestBatch {
    //没用批处理
    @Test
    public void testNoBatch() throws Exception {
        Connection con = JDBCUtils.getConnect();

        PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO admin VALUES (null,?,?)");

        for (int i = 0; i < 50000; i++) {
            preparedStatement.setString(1,"john");
            preparedStatement.setString(2,"0000");

            preparedStatement.executeUpdate();
        }

        JDBCUtils.close(null,preparedStatement,con);

    }


    public void testBatch() throws Exception {
        Connection con = JDBCUtils.getConnect();

        PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO admin VALUES (null,?,?)");

        for (int i = 0; i < 50000; i++) {
            preparedStatement.setString(1,"john");
            preparedStatement.setString(2,"0000");
            preparedStatement.addBatch();
//            preparedStatement.executeUpdate();
            if(i%1000 == 0){
                preparedStatement.executeBatch();
                preparedStatement.clearBatch();
                System.out.println("ss");
            }
        }

        JDBCUtils.close(null,preparedStatement,con);

    }

    public static void main(String[] args) throws Exception {
        new TestBatch().testBatch();
    }
}
