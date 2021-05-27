package com.atguigu.java;

/**
 * @author Meiko
 * @create 2021-05-27 20:13
 */
public class TestStringBuffer {

    public static void main(String[] args) {
        StringBuffer sb1 = new StringBuffer();
        String str = null;
        sb1.append(str);
        System.out.println(sb1);//"null"
        System.out.println(sb1.length());//4

        StringBuffer sb2 = new StringBuffer(str);//此处抛异常NullPointerException
        System.out.println(sb2);
        System.out.println(sb2.length());
    }
}

