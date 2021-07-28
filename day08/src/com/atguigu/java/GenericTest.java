package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 泛型的使用：JDK5.0新增的特性
 *
 * @author Meiko
 * @date 2021-07-27
 */
public class GenericTest {

    @Test
    public void test1() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(33);
        list.add(72);
        list.add(58);
        //使用了泛型在添加元素时就会进行类型检查
        //list.add("aa");

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int score = iterator.next();
            System.out.println(score);
        }
    }

    @Test
    public void test2() {
        Order order = new Order();
        order.setOrderT("aaa");
        order.setOrderT(123);

        Order<Integer> order1 = new Order<>();
        order1.setOrderT(123);
    }

    @Test
    public void test3() {
        //由于子类在继承带泛型的父类时指明了泛型类型，则子类在实例化时不需要再指定泛型类型
        SubOrder subOrder = new SubOrder();
        subOrder.setOrderT(123);

        SubOrder1<String> subOrder1 = new SubOrder1<>();
        subOrder1.setOrderT("123");
    }

    @Test
    public void test4() {
        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = new ArrayList<>();
        /*
         * 泛型不同的引用不能相互赋值
         * 尽管在编译时ArrayList<String>和ArrayList<Integer>是两种类型，
         * 但运行时只有一个ArrayList被加载到JVM中
         */
        // list1 = list2;
    }

    // 测试泛型方法
    @Test
    public void test5() {
        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1,2,3,4};
        List<Integer> list = order.copyArrayToList(arr);
        System.out.println(list);
    }
}
