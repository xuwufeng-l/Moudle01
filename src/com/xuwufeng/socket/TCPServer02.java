package com.xuwufeng.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 许武峰
 * @create 2020-01-28-15:15
 */
public class TCPServer02 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);
        Socket socket = server.accept();
        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len =0;
        while ((len = is.read(bytes))!= -1){
            System.out.println(new String(bytes,0,len));
        }
    }
}
