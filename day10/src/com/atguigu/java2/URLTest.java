package com.atguigu.java2;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL网络编程
 *
 * @author Meiko
 * @date 2021-08-19
 */
public class URLTest {

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/examples/1.jpg");
        System.out.println(url.getProtocol());
        System.out.println(url.getHost());
        System.out.println(url.getPort());
        System.out.println(url.getPath());
        System.out.println(url.getQuery());
    }
}
