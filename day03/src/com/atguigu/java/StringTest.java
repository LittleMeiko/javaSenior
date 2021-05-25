package com.atguigu.java;

import org.junit.Test;

/**
 *  常用类：String
 *
 *  面试题1：String str = new String("abc"); --> 创建了两个对象，堆空间：str,字符串常量池：abc
 *
 * @author Meiko
 * @create 2021-05-17 20:14
 */
public class StringTest {

    @Test
    public void test3 () {
        char[] ch = {'t','e','s','t'};
        System.out.println(ch);
        String[] str = {"test","ok"};
        System.out.println(str);
        int[] arr1 = {1,2,3};
        System.out.println(arr1);
        boolean[] arr2 = {true,false};
        System.out.println(arr2);
    }

    /*
     * 1.常量与常量的拼接结果在常量池，且常量池中不会存在相同内容的常量
     * 2.只要其中有一个是变量，就等价于new String(),其结果在堆中
     * 3.如果拼接的结果调用intern(),返回值就在常量池中
     */
    @Test
    public void test2 () {
        String s1 = "JavaEE";
        String s2 = "Hadoop";
        String s3 = "JavaEEHadoop";
        String s4 = "JavaEE" + "Hadoop";
        String s5 = s1 + "Hadoop";
        String s6 = "JavaEE" + s2;
        String s7 = s1 + s2;
        String s8 = s5.intern();
        String s9 = s6.intern();
        String s10 = s7.intern();

        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false
        System.out.println(s3 == s7);//false
        System.out.println(s5 == s6);//false
        System.out.println(s5 == s7);//false
        System.out.println(s6 == s7);//false
        System.out.println("********************************");
        System.out.println(s3 == s8);//true
        System.out.println(s3 == s9);//true
        System.out.println(s3 == s10);//true
        System.out.println(s4 == s8);//true

    }

    @Test
    public void test1 () {
        String s1 = "Java";
        String s2 = "Java";
        String s3 = new String("Java");
        String s4 = new String("Java");
        System.out.println(s1 == s2);//true
        System.out.println(s1 == s3);//false
        System.out.println(s3 == s4);//false
        System.out.println("*****************************");
        char[] charArr = new char[]{'J','a','v','a'};
        String s5 = new String(charArr, 0, 4);
        System.out.println(s1 == s5);//false
        System.out.println(s3 == s5);//false
        System.out.println("*****************************");
        Person p1 = new Person("Tom", 12);
        Person p2 = new Person("Tom", 12);
        System.out.println(p1.name == p2.name);//true
        p2.name = "Jerry";
        System.out.println(p1.name == p2.name);//false
    }

}

class Person {
    String name;
    int age;

    public Person() {

    }

    public Person(String name,int age) {
        this.name = name;
        this.age = age;
    }
}
