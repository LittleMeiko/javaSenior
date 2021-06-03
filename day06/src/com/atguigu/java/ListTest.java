package com.atguigu.java;

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
 *
 * @author Meiko
 * @date 2021-06-03
 */
public class ListTest {


}
