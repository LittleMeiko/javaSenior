package com.atguigu.java;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

/**
 * 注解的使用：
 * JDK5.0新增的，代码里的特殊标记
 *
 * 元注解：对现有的注解进行解释说明的注解
 *   1.Retention：用于指定Annotation的生命周期，包含一个RetentionPolicy类型的成员变量
 *      RetentionPolicy.SOURCE：在源文件中有效，编译器会直接丢弃这种策略的注解
 *      RetentionPolicy.CLASS：在class文件中有效，当运行Java程序时，JVM不会保留注解(默认值)
 *      RetentionPolicy.RUNTIME：在运行时有效，当运行Java程序时，JVM会保留注解，程序可以通过反射获取该注解
 *   2.Target：用于指定被修饰的注解能用于修饰哪些程序元素
 *   3.Documented：用于指定被该元注解修饰的注解类将被javadoc工具提取成文档，默认情况下javadoc是不包括注解的
 *      定义为Documented的注解必须设置Retention值为RUNTIME
 *   4.Inherited：被它修饰的注解将具有继承性
 *
 *  使用反射获取注解信息
 *
 *  JDK8中的注解新特性：
 *     1.可重复注解：@Repeatable(MyAnnotations.class)
 *     2.类型注解：
 *       ElementType.TYPE_PARAMETER：表示该注解能写在类型变量的声明语句中(例如：泛型声明)
 *       ElementType.TYPE_USE：表示该注解能写在使用类型的任何语句中
 *
 * @author Meiko
 * @create 2021-05-31 19:57
 */
public class AnnotationTest {

    @Test
    public void test1() {
        Annotation[] annotations = Student.class.getAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            System.out.println(annotations[i]);
        }
    }

}

//@MyAnnotation(value = "hi")
//注解重复使用,JDK8之前的写法
//@MyAnnotations({@MyAnnotation(value = "abc"), @MyAnnotation(value = "hi")})
@MyAnnotation(value = "abc")
@MyAnnotation(value = "hi")
class Person {

    private String name;
    private int age;

    public Person() {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Student extends Person {

}

class Generic<@MyAnnotation T> {

    public void show() throws @MyAnnotation RuntimeException{
        ArrayList<@MyAnnotation String> list = new ArrayList<>();
        int num = (@MyAnnotation int)10L;
    }
}
