package com.atguigu.java;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 类加载器：
 *     系统类加载器：加载自定义类
 *     扩展类加载器：通常加载java工程下lib文件夹下的文件
 *     引导类加载器：加载java的核心类库
 *
 * @author Meiko
 * @date 2021-08-20
 */
public class ClassloaderTest {

    @Test
    public void test() {
        //系统类加载器
        ClassLoader classLoader = ClassloaderTest.class.getClassLoader();
        System.out.println(classLoader);
        //扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);
        //引导类加载器：获取不到，不能用来加载自定义类
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);
    }

    @Test
    public void test2() throws IOException {
        Properties properties = new Properties();
        //properties.load(new FileInputStream("jdbc.properties"));

        //方式二加载配置文件
        ClassLoader classLoader = ClassloaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
        properties.load(is);

        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        System.out.println("username=" + username);
        System.out.println("passowrd=" + password);
    }
}
