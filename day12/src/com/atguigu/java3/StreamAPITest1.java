package com.atguigu.java3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * StreamAPI的中间操作：
 *  1.筛选与切片
 *  2.映射
 *  3.排序
 *
 * @author Meiko
 * @date 2021-09-02
 */
public class StreamAPITest1 {

    //筛选与切片
    @Test
    public void test1() {
        List<Integer> list = new ArrayList<>();
        list.add(-100);
        list.add(-50);
        list.add(-25);
        list.add(-100);
        list.add(12);
        list.add(25);
        list.add(96);
        list.add(25);
        Stream<Integer> stream = list.stream();
        stream.filter(i -> i < 0).forEach(System.out :: println);
        System.out.println("********************************");
        list.stream().limit(3).forEach(System.out :: println);
        System.out.println("********************************");
        list.stream().skip(3).forEach(System.out :: println);
        System.out.println("********************************");
        list.stream().distinct().forEach(System.out :: println);
    }

    //映射
    @Test
    public void test2() {
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out :: println);
        System.out.println("****************************");
        list.stream().map(StreamAPITest1::transStringToStream).forEach(str -> str.forEach(System.out :: println));
        System.out.println("****************************");
        list.stream().flatMap(StreamAPITest1 :: transStringToStream).forEach(System.out :: println);
    }

    public static Stream<Character> transStringToStream(String str) {
        ArrayList<Character> list = new ArrayList();
        for(Character cha : str.toCharArray()) {
            list.add(cha);
        }

        return list.stream();
    }

    //排序
    @Test
    public void test3() {
        List<Integer> list = Arrays.asList(12, 23, 98, 75, 0, -36, -12, 100);
        list.stream().sorted().forEach(System.out::println);
        System.out.println("*****************************");
        list.stream().sorted((o1,o2) -> -o1.compareTo(o2)).forEach(System.out::println);
    }
}
