package com.atguigu.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * 集合框架：
 * /--Collection接口：单列集合，存储一个一个的对象
 *    /--List接口：存储有序的、可重复的数据
 *       /--ArrayList、LinkedList、Vector
 *
 *    /--Set接口：存储无序的、不可重复的数据
 *      /--HashSet、LinkedHashSet、TreeSet
 *
 * /--Map接口：双列集合，用来存储一对一对的数据
 *    /--HashMap、LinkedHashMap、TreeMap、HashTable、Properties
 *
 *
 * @author Meiko
 * @create 2021-06-01 19:24
 */
public class CollectionTest {

    @Test
    public void test() {
        Collection coll = new ArrayList();
        coll.add("AA");
        coll.add("BB");
        coll.add(123);
        coll.add(new Date());
        coll.add(456);

        Collection coll1 = new ArrayList();
        coll1.add("CC");
        coll1.add(789);
        coll.addAll(coll);
        System.out.println(coll);

        coll.clear();

        System.out.println(coll.size());


    }

}
