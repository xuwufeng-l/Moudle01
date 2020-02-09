package com.xuwufeng.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 许武峰
 * @create 2020-01-28-13:17
 */
/*
    创建指定端口号的服务器套接字
    服务器必须明确知道是哪个服务器 通过accept（）方法
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //创建指定端口号的serversocket对象
        ServerSocket server = new ServerSocket(8888);
        //获取请求的socket对象
        Socket socket = server.accept();
        //使用socket对象方法中的getinputstream（）获取网络字节输入流 InputStresm
        InputStream is = socket.getInputStream();
        //使用网络字节输入流的read方法（），读取客户端发送到数据
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println(new String(bytes,0,len));
        //使用socket中的getoutputstream获取网络字节输入流outputstream对象
        OutputStream os = socket.getOutputStream();
        //使用网络字节输出流outputStream的方法write给客户端回写数据
        os.write("收到谢谢".getBytes());
        socket.close();
        server.close();
    }

}
