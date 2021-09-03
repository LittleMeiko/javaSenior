package com.atguigu.java3;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * StreamAPI的终止操作
 *
 * @author Meiko
 * @date 2021-09-02
 */
public class StreamAPITest2 {

    //查找与匹配
    @Test
    public void test1() {
        List<String> list = Arrays.asList("a", "bc", "def", "g", "higklm","abc");
        boolean allMatch = list.stream().allMatch(str -> str.length() > 0);
        System.out.println(allMatch);

        boolean anyMatch = list.stream().anyMatch(str -> str.startsWith("a"));
        System.out.println(anyMatch);

        boolean noneMatch = list.stream().noneMatch(str -> str.equals("z"));
        System.out.println(noneMatch);

        Optional<String> first = list.stream().findFirst();
        System.out.println(first);

        Optional<String> findAny = list.stream().findAny();
        System.out.println(findAny);

        long count = list.stream().filter(str -> str.length() > 2).count();
        System.out.println(count);

        Optional<String> max = list.stream().max(String::compareTo);
        System.out.println(max);

        Optional<String> min = list.stream().min(String::compareTo);
        System.out.println(min);
    }

    //规约
    @Test
    public void test2() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);
    }

    //收集
    @Test
    public void test3() {
        List<String> list = Arrays.asList("a", "bc", "def", "g", "higklm","abc", "def");
        List<String> stringList = list.stream().filter(str -> str.length() > 2).collect(Collectors.toList());
        stringList.forEach(System.out :: println);
        System.out.println("*****************************************");
        Set<String> stringSet = list.stream().filter(str -> str.length() > 2).collect(Collectors.toSet());
        stringSet.forEach(System.out :: println);
    }
}
