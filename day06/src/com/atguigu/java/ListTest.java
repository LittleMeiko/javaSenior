package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * List接口的相关实现类：ArrayList、LinkedList、Vector
 *
 * 面试题：ArrayList、LinkedList、Vector三者的异同？
 *    相同：三者都实现了List接口；存储数据的特点相同：有序、可重复；ArrayList和Vector底层都使用Object[] elementData存储
 *    不同：
 *         ArrayList(JDK1.2)：List接口的主要实现类;线程不安全的，效率高；
 *         LinkedList(JDK1.2)：对于频繁的插入、删除操作，使用此类效率比ArrayList高；底层使用双向链表存储；
 *         Vector(JDK1.0)：List接口的古老实现类；线程安全的，效率低；
 *
 * 1.ArrayList底层源码分析：
 *    JDK7：ArrayList list = new ArrayList();//底层创建了一个长度为10的Object[]数组elementData
 *          list.add(123);//elementData[0]=new Integer(123)
 *          ...
 *          list.add(789);//如果此次添加导致底层elementData数组容量不够则扩容。默认情况下扩容为原来的1.5倍，同时将原来数组
 *          中的元素复制到新的数组中。
 *    JDK8中的变化：
 *          ArrayList list = new ArrayList();//底层Object[] elementData初始化为{},并没有创建长度为10的数组
 *          list.add(123);//第一次调用add()时才创建了长度为10的数组，并将数据123添加到elementData[0]
 *          ...
 *          后续的添加与扩容与JDK7无异
 *    结论：JDK8中延迟了数组的创建时间，节省了内存空间。
 *
 * 2.LinkedList底层源码分析：
 *    LinkedList list = new LinkedList();//内部声明了一个类型为Node的first和last属性，默认值为null
 *    list.add(123);//将123封装到Node中，创建了Node对象。
 *
 * 3.Vector底层源码分析：
 *    在JDK7和JDK8中通过Vector()构造方法创建对象时，都创建了一个长度为10的Object[] elementData数组
 *    在扩容方面，默认为扩容为原来数组长度的2倍
 *
 * 4.ArrayList常用方法：增、删、改、查、插、长度、遍历
 *
 * @author Meiko
 * @date 2021-06-03
 */
public class ListTest {

    @Test
    public void test3() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        //1.迭代器遍历
        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("*********************");

        //2.增强for循环
        for (Object obj : list) {
            System.out.println(obj);
        }
        System.out.println("*********************");

        //3.普通循环
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    @Test
    public void test2() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom", 12));
        list.add(456);

        int index = list.indexOf(456);
        System.out.println(index);
        int lastIndexOf = list.lastIndexOf(456);
        System.out.println(lastIndexOf);

        Object remove = list.remove(0);
        System.out.println(remove);
        System.out.println(list.toString());

        Object cc = list.set(0, "CC");
        System.out.println(cc);
        System.out.println(list.toString());

        List list1 = list.subList(2, 4);
        System.out.println(list1.toString());
        System.out.println(list.toString());
    }

    @Test
    public void test1() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom", 12));
        list.add(456);
        System.out.println(list.toString());

        list.add(1,789);
        System.out.println(list.toString());
        List list1 = Arrays.asList(1, 2, 3);
        list.addAll(list1);
        System.out.println(list.size());
        System.out.println(list.toString());
        System.out.println(list.get(0));
    }
}
