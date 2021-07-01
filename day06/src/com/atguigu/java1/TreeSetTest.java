package com.atguigu.java1;

import org.junit.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Meiko
 * @date 2021-07-01
 */
public class TreeSetTest {

    /**
     * 向TreeSet添加数据时，要求是相同类的对象
     *
     */
    @Test
    public void test1() {
        Set set = new TreeSet();
        set.add(123);
        set.add(-125);
        set.add(36);
        set.add(456);
        //set.add("AA");

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
