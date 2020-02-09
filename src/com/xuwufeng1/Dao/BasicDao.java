package com.xuwufeng1.Dao;

import com.xuwufeng.utils.JDBCUtilsByDriud;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 许武峰
 * @create 2020-02-07-18:18
 */
public class BasicDao<T> {
    QueryRunner qr = new QueryRunner();
    /**
     * 通用增删改方法
     */
    public int update(String sql,Object...params){

        Connection connect = null;
        try {
            connect = JDBCUtilsByDriud.getConnect();
            int update = qr.update(connect, sql, params);
            return update;
        } catch (Exception e) {

            throw new RuntimeException(e);
        }finally {
            try {
                JDBCUtilsByDriud.close(null,null,connect);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 功能 返回单个对象针对任何表
     *
     * @param sql
     * @param clazz
     * @param params
     * @param
     * @return
     */
    public T querySingle(String sql,Class<T> clazz ,Object...params){
        Connection connection = null;
        try {
            connection = JDBCUtilsByDriud.getConnect();
            return qr.query(connection,sql,new BeanHandler<T>(clazz),params);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            try {
                JDBCUtilsByDriud.close(null,null,connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public  List<T> queryMulti(String sql,Class<T> clazz ,Object...params){
        Connection connection = null;
        try {
            connection = JDBCUtilsByDriud.getConnect();

            return qr.query(connection,sql,new BeanListHandler<T>(clazz),params);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            try {
                JDBCUtilsByDriud.close(null,null,connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Object scalar(String sql,Object...params){
        Connection connection = null;
        try {
            connection = JDBCUtilsByDriud.getConnect();

            return qr.query(connection,sql,new ScalarHandler<>(),params);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            try {
                JDBCUtilsByDriud.close(null,null,connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
