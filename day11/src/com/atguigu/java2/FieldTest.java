package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 获取当前运行时类的属性结构
 *
 * @author Meiko
 * @date 2021-08-23
 */
public class FieldTest {

    @Test
    public void test1() {
        Class<Person> clazz = Person.class;
        //获取本类及其父类中声明为public的属性
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("******");
        //获取本类中声明的属性
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
    }

    @Test
    public void test2() {
        Class<Person> clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            int modifier = declaredField.getModifiers();
            System.out.print(Modifier.toString(modifier) + "\t");
            String fType = declaredField.getType().getName();
            System.out.print(fType + "\t");
            String fName = declaredField.getName();
            System.out.println(fName);
        }
    }
}
