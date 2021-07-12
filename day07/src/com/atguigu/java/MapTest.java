package com.atguigu.java;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 一、Map实现类的结构：
 * /--------Map：双列数据，key-value类型的键值对数据
 *      /-------HashMap：JDK1.2,作为Map的主要实现类；线程不安全的，效率高；可以存储null的key或value
 *          /---LinkedHashMap：JDK1.4；可按照添加的顺序遍历元素，对于频繁的遍历操作，此类的效率要高于HashMap
 *      /-------TreeMap：JDK1.2；可保证按照添加的key-value键值对进行遍历，实现排序遍历，此时考虑key的自然排序或者定制排序，底层使用红黑树；
 *      /-------Hashtable：JDK1.0,作为古老的实现类；线程安全的，效率低；不能存储null的key或value
 *          /---Properties：JDK1.0；常用来处理配置文件；key和value都是String类型；
 *
 * 二、Map结构的理解：
 *    Map中的key：无序、不可重复的，使用Set存储所有的key ----> key所在的类要重写hashCode()和equals()
 *    Map中的value：无序、可重复的，使用Collection来存储所有的value -----> value所在的类要重写equals()
 *    键值对：key-value构成了一个Entry对象
 *    Map中的Entry：无序、不可重复的，使用Collection来存储所有的键值对
 *
 *
 *
 * HashMap的底层：<=JDK7 数组+链表
 *                JDK8   数组+链表+红黑树
 *
 */
public class MapTest {

    @Test
    public void testMap() {
        Map map = new HashMap<String,String>();
        map.put(null, 1);
        map.put(1, null);
        map.put(null, null);
    }
}
