package com.xuwueng;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author 许武峰
 * @create 2020-02-06-17:47
 */
public class TestTransaction {

    /**
     * 没用使用事务的情况下两条sql语句独立存在不影响对应方
     * @throws Exception
     */
    public void testNoTotransaction() throws Exception {
        Connection con = JDBCUtils.getConnect();

        //执行生气了语句
        PreparedStatement preparedStatement = con.prepareStatement("UPDATE account SET balance = ? WHERE  username = ?");
        preparedStatement.setDouble(1,1000);
        preparedStatement.setString(2,"kkkk");

        preparedStatement.executeUpdate();

        preparedStatement.setDouble(1,1500);
        preparedStatement.setString(2,"oooo");

        preparedStatement.executeUpdate();

        JDBCUtils.close(null,preparedStatement,con);




    }

    @Test
    public void testTransaction() throws Exception {

        Connection con = null;
        PreparedStatement preparedStatement = null;

        try {
            con = JDBCUtils.getConnect();

            //事务的使用步骤
            //开启事务 关闭自动提交
            con.setAutoCommit(false);
            //编写sql语句并执行


            preparedStatement = con.prepareStatement("UPDATE account SET balance = ? where username = ?");
            preparedStatement.setDouble(1,1000);
            preparedStatement.setString(2,"kkkk");

            preparedStatement.executeUpdate();



            preparedStatement.setDouble(1,1500);
            preparedStatement.setString(2,"oooo");

            preparedStatement.executeUpdate();

            //关闭事务
            //选择commit rollabck 判断是否有无异常
            con.commit();

        }catch (Exception e){
            con.rollback();

        }finally {
            JDBCUtils.close(null,preparedStatement,con);
        }




    }


    public static void main(String[] args) throws Exception {
        new TestTransaction().testTransaction();;
    }
}
