package com.atguigu.java3;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * StreamAPI的终止操作
 *
 * @author Meiko
 * @date 2021-09-02
 */
public class StreamAPITest2 {

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
    }
}
