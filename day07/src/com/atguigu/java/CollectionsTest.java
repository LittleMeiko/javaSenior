package com.atguigu.java;

import org.junit.Test;
import org.omg.CORBA.Object;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Collections是操作集合和Map的工具类
 *
 * @author Meiko
 * @date 2021-07-26
 */
public class CollectionsTest {

    @Test
    public void test2() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(45);
        list.add(-77);
        list.add(-25);
        list.add(789);
        list.add(0);
        list.add(45);

        List dest = Arrays.asList(new Integer[list.size()]);
        Collections.copy(dest, list);
        System.out.println(dest);

        List list1 = Collections.synchronizedList(list);
        System.out.println(list1);
    }

    @Test
    public void test1() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(45);
        list.add(-77);
        list.add(-25);
        list.add(789);
        list.add(0);
        list.add(45);

        //洗牌
        // Collections.shuffle(list);
        Collections.swap(list, 0, 1);
        int frequency = Collections.frequency(list, 45);
        System.out.println(frequency);
        System.out.println(list);
    }
}
