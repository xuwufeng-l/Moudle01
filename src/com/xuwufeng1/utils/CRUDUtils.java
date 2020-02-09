package com.xuwufeng1.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 许武峰
 * @create 2020-02-06-22:11
 *
 * 封装增删改查
 * 1执行增删改
 * 2执行查询
 */
public class CRUDUtils {

    /**
     * 功能增删改
     * 正对于任何增删改语句
     * params 占位符
     * @return
     */
    public static int update(String sql,Object... params) throws Exception {

          try {
              //1获取连接
              Connection connect = JDBCUtilsByDriud.getConnect();

              //2sql yuju
              PreparedStatement statement = connect.prepareStatement(sql);
              int update =0;
              for (int i = 0; i < params.length; i++) {
                  statement.setObject(i+1,params[i]);
                  update = statement.executeUpdate();
              }


              return update;

          }catch (Exception e){
              throw new RuntimeException(e);
          }



    }

    public static admin queryString (String sql, Object... params) throws Exception {
        try {
            //1获取连接
            Connection connect = JDBCUtilsByDriud.getConnect();
            //2 执行查询
            PreparedStatement statement = connect.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {

                statement.setObject(i+1,params[i]);
            }
            ResultSet set = statement.executeQuery();
            admin ad = null;
            if(set.next()){
                int id = set.getInt(1);
                String username = set.getString(2);
                String password = set.getString(3);
                ad = new admin(id,username,password);
                return ad;
            }
            return null;

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static List<admin> queryMulti(String sql, Object...params) throws Exception {
        Connection connect =null;
        PreparedStatement statement = null;
        ResultSet set = null;
        try {
            connect = JDBCUtilsByDriud.getConnect();

            statement = connect.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i+1,params[i]);
            }
            set = statement.executeQuery();
            List<admin> list = new ArrayList<>();
            while(set.next()){
                int id = set.getInt(1);
                String username = set.getString(2);
                String password = set.getString(3);
                admin admin = new admin(id,username,password);
                list.add(admin);
                //return list;

            }
            return list;
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDriud.close(set,statement,connect);
        }

    }
}
