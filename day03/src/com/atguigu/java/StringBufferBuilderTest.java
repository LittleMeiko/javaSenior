package com.atguigu.java;

import org.junit.Test;

/**
 * String StringBuffer StringBuilder的异同：
 *  String：JDK1.0开始就有；不可变的字符序列；底层使用char型数组存储
 *  StringBuffer：JDK1.0开始就有，可变的字符序列；线程安全的，效率低；底层使用char型数组存储
 *  StringBuilder：JDK1.5新增，可变的字符序列；线程不安全的，效率高；底层使用char型数组存储
 *
 *  源码分析：
 *    String str = new String();//char[] value = new char[0];
 *    String str = new String("abc");//char[] value = new char[]{'a','b','c'};
 *
 *    StringBuffer sb1 = new StringBuffer();//char[] value = new char[16];底层创建了一个长度为16的字符数组
 *    System.out.println(sb1.length());//0
 *    sb1.append('a');//value[0] = 'a';
 *    sb1.append('b');//value[1] = 'b';
 *    sb1.append('c');//value[2] = 'c';
 *
 *    StringBuffer sb2 = new StringBuffer("abc");//char value = new char["abc".length + 16];
 *    System.out.println(sb2.length());//3
 *
 *  问题分析：
 *    扩容问题：如果要添加的数据底层数组存不下了，那么就需要扩容底层的数组
 *              默认是把底层数组扩容为原来的2倍+2，同时将原有数组元素复制到新的数组中
 *
 *  执行效率：StringBuilder > StringBuffer > String
 *
 * @author Meiko
 * @create 2021-05-25 20:56
 */
public class StringBufferBuilderTest {

    @Test
    public void test1() {
        StringBuffer sb1 = new StringBuffer();
        System.out.println(sb1.length());

        StringBuffer sb2 = new StringBuffer("abc");
        System.out.println(sb2.length());
    }
}
