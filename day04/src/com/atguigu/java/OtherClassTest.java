package com.atguigu.java;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * 其他常用类的使用:
 * 1.System
 *      currentTimeMillis(), exit(), gc(), getProperty()
 * 2.Math
 *
 * 3.BigInteger、BigDecimal
 *
 * @author Meiko
 * @create 2021-05-30 17:28
 */
public class OtherClassTest {

    @Test
    public void test1() {
        String javaVersion = System.getProperty("java.version");
        System.out.println("javaVersion:" + javaVersion);
        String javaHome = System.getProperty("java.home");
        System.out.println("javaHome:" + javaHome);
        String osName = System.getProperty("os.name");
        System.out.println("osName:" + osName);
        String osVersion = System.getProperty("os.version");
        System.out.println("osVersion:" + osVersion);
        String userName = System.getProperty("user.name");
        System.out.println("userName:" + userName);
        String userHome = System.getProperty("user.home");
        System.out.println("userHome:" + userHome);
        String userDir = System.getProperty("user.dir");
        System.out.println("userDir:" + userDir);
    }

    @Test
    public void test2() {
        BigDecimal b1 = new BigDecimal("98765988");
        BigDecimal b2 = new BigDecimal("11");
        System.out.println(b1.divide(b2, 5, BigDecimal.ROUND_HALF_DOWN));
    }
}
