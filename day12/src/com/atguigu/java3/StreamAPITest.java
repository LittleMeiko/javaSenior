package com.atguigu.java3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * StreamAPI：数据的运算
 *
 * @author Meiko
 * @date 2021-09-01
 */
public class StreamAPITest {

    // 创建Stream的方式一：通过集合的default stream()
    @Test
    public void test1() {
        List<String> strList = new ArrayList<>();
        strList.add("abc");
        strList.add("def");
        strList.add("ghi");
        strList.add("jkl");
        strList.add("mno");
        //顺序流
        Stream<String> stream = strList.stream();
        //并行流
        Stream<String> parallelStream = strList.parallelStream();
    }

    //创建Stream流的方式二：通过数组Arrays的stream()
    @Test
    public void test2() {
        int[] intArr = new int[]{1,2,3,4,5};
        IntStream intStream = Arrays.stream(intArr);
    }

    //创建Stream的方式三：Stream的static of()
    @Test
    public void test3() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    //创建Stream的方式四：创建无限流
    @Test
    public void test4() {
        //迭代
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out :: println);

        Stream.generate(Math :: random).limit(10).forEach(System.out :: println);
    }
}
