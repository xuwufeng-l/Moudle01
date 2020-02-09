package com.xuwufeng.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author 许武峰
 * @create 2020-01-28-13:04
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        //创建一个客户端对象socket构造方法绑定服务器IP地址 和端口号
        Socket socket = new Socket("127.0.0.1",8888);
        //获取socket中的方法getOutoutStream()获取网络字节输出流OutputStream
        OutputStream outputStream = socket.getOutputStream();
        //使用网络字节输出流  中的write给服务器发送数据
        outputStream.write("你好服务器".getBytes());
        //使用socket对象中的方法getinputstream获取inputstream对象
        InputStream is = socket.getInputStream();
        //使用网络字节输入流inputstream的方法read读取服务器回写数据
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println(new String(bytes,0,len));

        // 释放资源
        socket.close();


    }
}
