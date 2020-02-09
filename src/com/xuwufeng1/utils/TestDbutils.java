package com.xuwufeng1.utils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

/**
 * @author 许武峰
 * @create 2020-02-07-16:43
 */
public class TestDbutils {

    @Test
    public void testUpdate() throws Exception {
        //1获取连接
        Connection connect = JDBCUtilsByDriud.getConnect();
        QueryRunner qr = new QueryRunner();
        int update = qr.update(connect, "update admin set username = ? where id =2", "tom");
        System.out.println(update>0?"succ":"fal");

        JDBCUtilsByDriud.close(null,null,connect);
    }

    public void testQuerySingle() throws Exception {
        Connection connect = JDBCUtilsByDriud.getConnect();

        QueryRunner qr = new QueryRunner();

        admin query = qr.query(connect, "select * from admin where id = ?", new BeanHandler<>(admin.class), 1);
        System.out.println(query);

        JDBCUtilsByDriud.close(null,null,null);
    }

    public void testQueryMulti() throws Exception {
        Connection connect = JDBCUtilsByDriud.getConnect();

        QueryRunner qr = new QueryRunner();
        List<admin> query = qr.query(connect, "select * from admin where id> ?", new BeanListHandler<>(admin.class), 1);
        for (com.xuwufeng1.utils.admin admin : query) {
            System.out.println(admin );
        }

        JDBCUtilsByDriud.close(null,null,connect);

    }

    public void testScalar() throws Exception {
        Connection connect = JDBCUtilsByDriud.getConnect();
        QueryRunner qr = new QueryRunner();

        Object query = qr.query(connect, "select * from admin ", new ScalarHandler<>());
        System.out.println(query);
        JDBCUtilsByDriud.close(null , null,connect);
    }



    public static void main(String[] args) throws Exception {
        //new TestDbutils().testUpdate();
//        new TestDbutils().testQuerySingle();
//        new TestDbutils().testQueryMulti();
        new TestDbutils().testScalar();

    }
}
