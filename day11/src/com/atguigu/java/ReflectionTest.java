package com.atguigu.java;

import org.junit.Test;

/**
 * Class的实例就对应着一个运行时类
 *
 * 类的加载过程：
 * 类的加载(Load) -> 类的链接(Link) -> 类的初始化(initialize)
 *
 * @author Meiko
 * @date 2021-08-20
 */
public class ReflectionTest {

    //获取Class实例的方式
    @Test
    public void test1() throws ClassNotFoundException {
        //方式一
        Class clazz = Person.class;
        System.out.println(clazz);
        //方式二
        Person person = new Person();
        Class clazz2 = person.getClass();
        System.out.println(clazz2);
        //方式三
        Class<?> clazz3 = Class.forName("com.atguigu.java.Person");
        System.out.println(clazz3);

        System.out.println(clazz == clazz2);
        System.out.println(clazz == clazz3);

        //方式四
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("com.atguigu.java.Person");
        System.out.println(clazz4);
        System.out.println(clazz == clazz4);
    }
}
