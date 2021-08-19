package com.atguigu.java2;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * UDP编程实例
 *
 * @author Meiko
 * @date 2021-08-19
 */
public class UDPTest {

    @Test
    public void sender() throws IOException {
        DatagramSocket socket = new DatagramSocket();
        byte[] data = "我是UDP方式发送的消息".getBytes();
        DatagramPacket packet = new DatagramPacket(data, 0, data.length, InetAddress.getLocalHost(), 9090);
        socket.send(packet);
        socket.close();
    }

    @Test
    public void receiver() throws IOException {
        DatagramSocket socket = new DatagramSocket(9090);
        byte[] buffer = new byte[100];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);

        System.out.println(new String(packet.getData(), 0, packet.getLength()));
        socket.close();
    }
}
