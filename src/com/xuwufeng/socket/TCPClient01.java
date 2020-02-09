package com.xuwufeng.socket;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author 许武峰
 * @create 2020-01-28-13:59
 *  文件上传案例的客户端 读取本地文件 上传服务器 读取服务器
 */
/*
       数据源 C:\Users\dell\Desktop\毕业设计文件\图片1.jpg
       目的地 服务器
 */
public class TCPClient01 {
    public static void main(String[] args) throws IOException {

        //创建本地字节输入流 fileinputstream
        FileInputStream fis = new FileInputStream("C:\\Users\\dell\\Desktop\\毕业设计文件\\图片1.jpg");
        //创建一个客户端socket对象构造方法中绑定ip 端口号
        Socket socket  = new Socket("127.0.0.1",8888);
        //使用socket 方法getoutputstream 获取网络字节输出流对象
        OutputStream os = socket.getOutputStream();
        //使用本地文件流的read()方法读取本地文件
        int len =0;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes)) != -1){
            //使用网络流中write()把读取文件上传到服务器
            os.write(bytes,0,len);
        }
        socket.shutdownOutput();

        //网络流中的getinputstream获取网络字节输入流inputstream对象
        InputStream is = socket.getInputStream();
        //使用网络字节输入流inputstream的read（）回写数据
        while ((len = is.read(bytes)) != -1){
            System.out.println(new String(bytes,0,len));
        }


        //释放资源
        socket.close();
        fis.close();

    }
}
