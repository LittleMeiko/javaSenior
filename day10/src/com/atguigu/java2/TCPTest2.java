package com.atguigu.java2;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP编程实例2
 *
 * @author Meiko
 * @date 2021-08-19
 */
public class TCPTest2 {

    @Test
    public void client() throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 8899);
        OutputStream os = socket.getOutputStream();
        FileInputStream fis = new FileInputStream("上证指数.jpg");
        int len;
        byte[] cbuf = new byte[1024];
        while ((len = fis.read(cbuf)) != -1) {
            os.write(cbuf, 0, len);
        }
        socket.shutdownOutput();

        InputStream is = socket.getInputStream();
        int len1;
        byte[] cbuf1 = new byte[10];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        while ((len1 = is.read(cbuf1)) != -1) {
            baos.write(cbuf1, 0 , len1);
        }
        System.out.println(baos.toString());

        baos.close();
        fis.close();
        os.close();
        socket.close();
    }

    @Test
    public void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8899);
        Socket socket = serverSocket.accept();
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream("上证指数4.jpg");
        int len;
        byte[] cbuf = new byte[1024];
        while((len = is.read(cbuf)) != -1) {
            fos.write(cbuf, 0 , len);
        }

        OutputStream os = socket.getOutputStream();
        os.write("已收到图片".getBytes());

        os.close();
        fos.close();
        is.close();
        socket.close();
        serverSocket.close();
    }
}


