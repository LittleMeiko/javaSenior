package com.atguigu.java1;

import org.junit.Test;

import java.util.Comparator;

/**
 * Lambda表达式
 */
public class LambdaTest {
    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱学Java");
            }
        };
        r1.run();
        System.out.println("**************************************");
        Runnable r2 = () -> System.out.println("我爱学React");
        r2.run();
    }

    @Test
    public void test2() {
        Comparator<Integer> comp1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int result1 = comp1.compare(12, 32);
        System.out.println(result1);

        System.out.println("*********************************");

        //Lambda表达式
        Comparator<Integer> comp2 = (o1, o2) -> Integer.compare(o1, o2);
        int result2 = comp2.compare(32, 12);
        System.out.println(result2);

        System.out.println("*********************************");

        //方法引用
        Comparator<Integer> comp3 = Integer :: compare;
        int result3 = comp3.compare(32, 12);
        System.out.println(result3);
    }
}
