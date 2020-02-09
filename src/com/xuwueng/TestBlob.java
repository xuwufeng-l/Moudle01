package com.xuwueng;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author 许武峰
 * @create 2020-02-06-18:58
 */
public class TestBlob {
    public void toSave() throws Exception {
        Connection con = JDBCUtils.getConnect();

        PreparedStatement preparedStatement = con.prepareStatement("UPDATE bimage set photo = ? where id = 1");
        preparedStatement.setObject(1,new FileInputStream("C:\\Users\\dell\\Desktop\\毕业设计文件\\图片1.jpg"));
        int i = preparedStatement.executeUpdate();
        JDBCUtils.close(null,preparedStatement,con);

    }

    public void toRead() throws Exception {
        Connection con = JDBCUtils.getConnect();

        PreparedStatement preparedStatement = con.prepareStatement("SELECT photo FROM bimage where id = 1");
//        preparedStatement.setObject(1,new FileInputStream("C:\\Users\\dell\\Desktop\\毕业设计文件\\图片1.jpg"));
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            //方式1
//            Blob blob = resultSet.getBlob("photo");
//            InputStream binaryStream = blob.getBinaryStream();
            //2
            InputStream phout = resultSet.getBinaryStream("photo");
            FileOutputStream fos = new FileOutputStream("D:/test0002.jpg");

            int len ;
            byte[] bytes = new byte[1024];
            while((len = phout.read(bytes)) != -1){
                fos.write(bytes,0,len);
            }
            fos.close();


        }
        preparedStatement.executeQuery();

        JDBCUtils.close(null,preparedStatement,con);

    }

    public static void main(String[] args) throws Exception {
        new TestBlob().toRead();
    }
}
