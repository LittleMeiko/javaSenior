package com.atguigu.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * Properties常用来处理配置文件，key和value都是String类型
 *
 * @author Meiko
 * @date 2021-07-26
 */
public class PropertiesTest {

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("jdbc.properties");
        properties.load(fis);
        String name = properties.getProperty("name");
        String password = properties.getProperty("password");

        System.out.println("name=" + name + "," + "password=" + password);
    }
}
