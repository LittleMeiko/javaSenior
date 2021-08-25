package com.atguigu.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Java内置的四大核心函数式接口：
 *   1.消费型接口
 *      Consumer<T>   void accept(T t)
 *   2.供给型接口
 *      Supplier<T>   T get()
 *   3.函数型接口
 *      Function<T,R> R apply(T t)
 *   4.断定型接口
 *      Predicate<T>  boolean test(T t)
 */
public class LambdaTest2 {

    @Test
    public void test1() {
        happyTime(500, money -> System.out.println("买一双鞋子花了" + money));
    }

    public void happyTime(double money, Consumer<Double> con) {
        con.accept(money);
    }

    @Test
    public void test2() {
        List<String> initList = Arrays.asList("北京","南京","天津","东京","西京","普京");
        List<String> resultList = filterList(initList, str -> str.contains("京"));
        System.out.println(resultList);
    }

    public List<String> filterList(List<String> initList, Predicate<String> pre) {
        List<String> filterList = new ArrayList<>();
        for (String str : initList) {
            if (pre.test(str)) {
                filterList.add(str);
            }
        }

        return filterList;
    }
}
