package com.atguigu.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 1.泛型在继承方面的体现
 *   虽然类A是类B的父类，但是G<A>和G<B>二者不具备子父类关系，二者是并列关系
 *   类A是类B的父类，A<G>和B<G>具备子父类关系
 *
 * 2.通配符的使用
 *   类A是类B的父类，G<A>和G<B>是并列关系，二者共同的父类：G<?>
 *   2.1.有限制条件的通配符
 *        <? extends Number>: (无穷小, Number] 只允许泛型为Number及Number的子类的引用调用
 *        <? super Number>: [无穷大, Number) 只允许泛型为Number及Number的父类的引用调用
 *
 * @author Meiko
 * @date 2021-07-28
 */
public class GenericTest {

    @Test
    public void test1() {
        Object obj = null;
        String str = null;
        obj = str;

        Object[] objs = null;
        String[] strs = null;
        objs = strs;

        List<Object> list1 = null;
        List<String> list2 = null;
        //编译不通过
        //list1 = list2;

    }

    @Test
    public void test2() {
        List<Integer> list1 = null;
        List<String> list2 = null;
        print(list1);
        print(list2);
    }

    public void print(List<?> list) {
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }

    // 有限制条件的通配符的使用
    @Test
    public void test4() {
        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<Student> list3 = new ArrayList<>();
        List<Person> list4 = new ArrayList<>();
        List<Object> list5 = new ArrayList<>();

        list1 = list3;
        list1 = list4;
        //编译不通过,泛型的类型要 <=
//        list1 = list5;

        //编译不通过,泛型的类型要 >=
//        list2 = list3;
        list2 = list4;
        list2 = list5;

        //读数据
        Person person = list1.get(0);
        Object object = list2.get(0);

        //编译不通过
//        list1.add(new Student());
//        list1.add(new Person());
        list2.add(new Person());
        list2.add(new Student());
    }
}
