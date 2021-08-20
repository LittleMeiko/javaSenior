package com.atguigu.java;

import org.junit.Test;

/**
 * 通过反射创建对应的运行时类的对象
 *
 * @author Meiko
 * @date 2021-08-20
 */
public class NewInstanceTest {

    @Test
    public void test() throws IllegalAccessException, InstantiationException {
        Class clazz = Person.class;
        Person person = (Person)clazz.newInstance();
        System.out.println(person);
    }
}
