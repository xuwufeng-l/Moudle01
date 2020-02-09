package com.xuwufeng1.service;
import com.xuwufeng1.Dao.adminDao;

/**
 * @author 许武峰
 * @create 2020-02-07-18:47
 */
public class AdminService  {

    adminDao dao = new adminDao();
    public  boolean login(String username,String password){

        Object scalar =  dao.scalar("select count(*) from admin where username = ? and password = ?", username, password);
        return Integer.parseInt(scalar+"")>0;

    }
}
