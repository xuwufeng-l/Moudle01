package com.xuwufeng1.utils;

import java.util.List;

/**
 * @author 许武峰
 * @create 2020-02-06-22:20
 */
public class TestCRUDUils {

    public void testUpdate() throws Exception {
        //int jerry = CRUDUtils.update("update admin set username = ? where id = 1", "jerry");
        //System.out.println(jerry>0?"ss":"ff");
//        for (int i = 5; i < 7; i++) {
//            int update = CRUDUtils.update("delete from admin where id = ?", i);
//            System.out.println(update>0?"ss":"ff");
//        }
//        admin admin = CRUDUtils.queryString("select * from admin where id = ?", 1);
//        System.out.println(admin);

        List<admin> admins = CRUDUtils.queryMulti("select * from admin");
        System.out.println(admins.size());
        for (admin admin1 : admins) {
            System.out.println(admin1);
        }


    }

    public static void main(String[] args) throws Exception {
        new TestCRUDUils().testUpdate();
    }
}
