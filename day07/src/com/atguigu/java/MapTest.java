package com.atguigu.java;


import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
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
 * 三、HashMap的底层原理？以JDK7为例
 *    HashMap map = new HashMap(): 在实例化以后底层创建了一个长度为16的一维数组Entry[] table
 *    在此之前已经经历过多次put...
 *    put(key1,value1): 首先调用key1所在类的HashCode()计算出key1的哈希值，此哈希值经过某种算法计算以后，得到在Entry[]数组中的存放位置。
 *      如果此位置上的数据为空，那么key1-value1添加成功；----情况1
 *      如果此位置上的数据不为空，意味着此位置上此时存在的数据不止一个(以链表的形式存在)，此时就要比较key1和已经存在的一个或多个数据的哈希值：
 *          如果key1和已经存在的一个或多个数据的哈希值不一样，那么key1-value1添加成功；----情况2
 *          如果key1和已经存在的一个或多个数据的哈希值相同，则继续比较key1所在类的equals(key2):
 *              如果equals()返回false，则key1-value1添加成功；----情况3
 *              如果equals()返回true，则使用value1替换value2。
 *      情况2和情况3，key1-value1和原来的数据以链表的形式存储。
 *
 *    在不断的添加过程中会涉及到扩容问题，当超出临界值时且要存放的位置为空时扩容，默认的扩容方式：扩容为原来容量的2倍，并将原有的数据复制过来。
 *
 *    JDK8与JDK7在底层实现方面的不同？
 *      1.new HashMap()：底层并没有创建一个长度为16的数组
 *      2.JDK8的底层数组是Node[]而并非Entry[]
 *      3.首次调用put()时会创建一个长度为16的数组
 *      4.JDK7底层结构只有：数组+链表；JDK8中底层结构：数组+链表+红黑树。
 *        当数组的某一索引位置上的元素以链表形式存在的个数 > 8 并且 数组的长度 > 64，此时此索引位置上的元素改用红黑树存储。
 *
 * 四、LinkedHashMap底层实现原理？
 *     能够记录添加元素的先后顺序
 *
 *
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

    @Test
    public void testMap2() {
        Map map = new LinkedHashMap();
        map.put(1,"AA");
        map.put(2,"BB");
        map.put(3,"CC");
        System.out.println(map);
    }
}
