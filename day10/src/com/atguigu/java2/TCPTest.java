package com.atguigu.java2;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

/**
 * TCP编程实例
 *
 * @author Meiko
 * @date 2021-08-19
 */
public class TCPTest {

    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        try {
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet, 8899);
            os = socket.getOutputStream();
            os.write("我是客户端".getBytes());
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(os)) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (Objects.nonNull(socket)) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            serverSocket = new ServerSocket(8899);
            socket = serverSocket.accept();
            is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            int len;
            byte[] cbuf = new byte[5];
            while((len = is.read(cbuf)) != -1) {
                baos.write(cbuf,0, len);
            }
            System.out.println("收到来自：" + socket.getInetAddress().getHostAddress() + "发送的消息");
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(baos)) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (Objects.nonNull(is)) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (Objects.nonNull(socket)) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (Objects.nonNull(serverSocket)) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
