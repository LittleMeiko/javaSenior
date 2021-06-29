package com.atguigu.java1;

import com.atguigu.java.Person;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 1.Set接口的框架:
 * /--Collection接口：单列集合，存储一个一个的对象
 *    /--Set接口：存储无序的、不可重复的数据
 *       /--HashSet：Set接口的主要实现类，非线程安全的，可以存储null值
 *          /--LinkedHashSet：HashSet的子类，在遍历其内部数据时，可以按照添加的顺序遍历
 *       /--TreeSet：可以按照添加对象的指定属性进行排序
 *
 *
 *
 *
 */
public class SetTest {

    /**
     * 一、Set接口：存储无序的、不可重复的数据
     *    1.无序性：无序不等于随机性。存储的数据在底层数组中并非按照数组索引顺序添加，而是根据数据的hash值存放。
     *
     *    2.不可重复性：保证添加的元素在按equals()判断时不能返回true，即相同的元素只能添加一个。
     *
     * 二、添加元素的过程：以HashSet为例：
     *    当向HashSet中添加元素a时，首先调用元素a所在类的hashCode()方法，计算元素a的哈希值，接着此哈希值经过某种
     *    算法计算出其在HashSet底层数组中的存放位置(即：索引位置)，然后判断数组此位置上是否已经有元素：
     *         如果数组此位置上没有其它元素，则元素a添加成功。 ---> 情况1
     *         如果数组此位置上存在其它元素b(或者以链表形式存在的多个元素)，则比较元素a与元素b的哈希值：
     *              如果哈希值不相同，则元素a添加成功。---> 情况2
     *              如果哈希值相同，则再调用元素a所在类的equals()方法：
     *                  equals()方法返回true，则元素a添加失败。
     *                  equals()方法返回false，则元素a添加成功。 ---> 情况3
     *    对于添加成功的情况2与情况3而言：元素a与已经存在指定索引位置上的元素以链表的方式存储。
     *         JDK7：元素a放到数组中指向原来的元素。
     *         JDK8：原来的元素在数组中指向元素a。
     *
     *    HashSet底层数据结构：数组+链表
     *
     *    注意：在向HashSet中添加数据时，要重写元素所在类的hashCode()和equals()
     */
    @Test
    public void test1() {
        Set set = new HashSet();
        set.add(123);
        set.add(456);
        set.add("AA");
        set.add(new Person("Tom", 12));
        set.add("CC");
        set.add(789);

        Iterator it = set.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
