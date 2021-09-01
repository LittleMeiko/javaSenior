package com.atguigu.java2;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 方法引用与构造器引用
 */
public class FunctionReferenceTest {

    @Test
    public void test1() {
        Consumer<String> conn1 = str -> System.out.println(str);
        conn1.accept("I like to learn java!");

        System.out.println("********************************");

        PrintStream ps = System.out;
        Consumer<String> conn2 =  ps :: println;
        conn2.accept("I like to learn java!");
    }

    @Test
    public void test2() {
        Comparator<Integer> com1 = (t1,t2) -> Integer.compare(t1, t2);
        System.out.println(com1.compare(12, 21));

        System.out.println("******************************");

        Comparator<Integer> com2 = Integer :: compare;
        System.out.println(com2.compare(12, 21));
    }

    @Test
    public void test3() {
        Function<Double, Long> func1 = d -> Math.round(d);
        System.out.println(func1.apply(12.3));

        System.out.println("***************************");

        Function<Double, Long> func2 = Math :: round;
        System.out.println(func2.apply(12.6));
    }

    @Test
    public void test4() {
        Comparator<String> com1 = (s1,s2) -> s1.compareTo(s2);
        System.out.println(com1.compare("abc", "def"));

        System.out.println("*******************************");

        Comparator<String> com2 = String :: compareTo;
        System.out.println(com2.compare("abc", "def"));
    }

    @Test
    public void test5() {
        BiPredicate<String, String> pre = (s1, s2) -> s1.equals(s2);
        System.out.println(pre.test("abc", "abc"));

        System.out.println("*************************************");

        BiPredicate<String, String> pre2 = String :: equals;
        System.out.println(pre2.test("abc", "abd"));
    }

    /**
     * 数组引用
     */
    @Test
    public void test6() {
        Function<Integer, String[]> func1 = length -> new String[length];
        System.out.println(Arrays.toString(func1.apply(5)));

        System.out.println("********************************");

        Function<Integer, String[]> func2 = String[] :: new;
        System.out.println(Arrays.toString(func2.apply(10)));
    }
}
