package com.atguigu.java2;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 网络编程
 * 1.InetAddress表示IP
 */
public class InetAddressTest {

    @Test
    public void test1() {
        try {
            InetAddress inetAddress = InetAddress.getByName("192.168.172.68");
            System.out.println(inetAddress);

            InetAddress inetAddress1 = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress1.getHostAddress());
            System.out.println(inetAddress1.getHostName());
            System.out.println(inetAddress1);

            InetAddress inetAddress2 = InetAddress.getByName("127.0.0.1");
            System.out.println(inetAddress2);

            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
