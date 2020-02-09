package com.xuwufeng.socket;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * @author 许武峰
 * @create 2020-01-28-14:16
 * 服务器端 读取文件上传文件 保存到服务器硬盘 给客户端回写
 * 数据源：客户端上传文件
 * 目的地：服务器硬盘 D:\\upload\\1.jpg
 */
public class TCPServer01 {
    public static void main(String[] args) throws IOException {
        //创建一个serversocket对象 和系统指定的端口号
        ServerSocket server = new ServerSocket(8888);
        //使用serversocket对象的accept方法获取请求客户端对象
        /*
        一直处于监听状态
        有一个客户端上传文件即可以保持
         */
        while(true) {
            /*
            使用多线程，提高程序效率 有一个客户端上传文件 就开启一个线程 完成文件上传
             */
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Socket socket = server.accept();
                        //使用socket的getinputstream 获取网络字节输入流inputstream
                        InputStream is = socket.getInputStream();
                        //判断D盘是否有文件没有创建
                        File file = new File("D:\\upload");
                        if (!file.exists()) {
                            file.mkdirs();
                        }
        /*
        修正版
        自定义一个文件命名规则 防止同名的文件被覆盖
        规则：域名+毫秒值+随机数
         */
                        String fileName = "itcast" + System.currentTimeMillis() + new Random().nextInt(999999) + ".jpg";

                        //创建一个本地字节输出流fileoutputstream对象，构造方法中绑定要输出的目的地
                        //FileOutputStream fos = new FileOutputStream(file+"\\1.jpg");
                        FileOutputStream fos = new FileOutputStream(file + "\\"+fileName);
                        //使用网络流中的inputstream的read（）读取上传文件
                        int len = 0;
                        byte[] bytes = new byte[1024];
                        while ((len = is.read(bytes)) != -1) {
                            //使用本地字节流fileoutputs的方法write写到目的地
                            fos.write(bytes, 0, len);
                        }

                        //使用网络流的getoutputstream 获取网络字节流OutputStream
                        socket.getOutputStream().write("上传成功".getBytes());
                        //使用网络流的write方法给客户端回写“上传成功

                        //释放资源（file socke serversocket
                        fos.close();
                        socket.close();
                    }catch (IOException e){
                        System.out.println(e);
                    }
                }
            }).start();


        }
        //一直启动服务器不需要关闭
       // server.close();
    }
}
