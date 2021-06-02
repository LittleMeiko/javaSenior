package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *  集合元素的遍历
 *  next()：①下移游标 ②将当前位置上的元素返回
 *
 * @author Meiko
 * @create 2021-06-02 21:33
 */
public class IteratorTest {

    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",20));

        Iterator iterator = coll.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    @Test
    public void test2() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",20));
        System.out.println(coll);

        Iterator iterator = coll.iterator();
        while(iterator.hasNext()) {
            Object next = iterator.next();
            if ("Tom".equals(next)){
                iterator.remove();
            }
        }
        System.out.println(coll);
    }
}
