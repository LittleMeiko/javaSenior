package com.atguigu.java;

import org.junit.Test;

import java.util.*;

/**
 * @author Meiko
 * @create 2021-06-02 20:36
 */
public class CollectionTest {

    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(new Date());
        coll.add(false);
        coll.add(new Person("Jerry",20));

        System.out.println(coll.contains("Tom"));//true
        System.out.println(coll.contains(new String("Tom")));//true
        //没有重写Person类的equals()时结果为false,重写后结果为true
        System.out.println(coll.contains(new Person("Jerry", 20)));

        Collection coll1 = Arrays.asList(123,456,new Person("Jerry",20));
        System.out.println(coll.containsAll(coll1));//true
    }

    @Test
    public void test2() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(new Date());
        coll.add(false);
        coll.add(new Person("Jerry",20));

        boolean isRemove = coll.remove(1234);
        System.out.println(isRemove);//false
        System.out.println(coll);

        Collection coll1 = Arrays.asList(123,4567);
        boolean isRemoveAll = coll.removeAll(coll1);
        System.out.println(isRemoveAll);//true
        System.out.println(coll);
    }

    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(new Date());
        coll.add(false);
        coll.add(new Person("Jerry",20));

        Collection coll1 = Arrays.asList(123,456);
        //求交集
        coll.retainAll(coll1);
        System.out.println(coll);
    }

    @Test
    public void test4() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",20));

        Collection coll2 = new ArrayList();
        coll2.add(123);
        coll2.add(456);
        coll2.add(new String("Tom"));
        coll2.add(false);
        coll2.add(new Person("Jerry",20));

        //因这里用Collection的实现类是ArrayList，当调用equals()时，若想返回true，
        // 则必须保证当前集合与形参集合的元素及顺序都是相同的，否则返回为false
        System.out.println(coll.equals(coll2));//true
    }

    @Test
    public void test5() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",20));
        System.out.println(coll.hashCode());

        //集合转换为数组toArray()
        Object[] objects = coll.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }
        System.out.println("****************************************");
        //数组转换为集合asList()
        List list1 = Arrays.asList(new String[]{"AA", "BB"});
        System.out.println(list1);

        List list2 = Arrays.asList(new int[]{123, 456});
        System.out.println(list2);//[[I@722c41f4]
        System.out.println(list2.size());//1

        List list3 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(list3);//[123, 456]
        System.out.println(list3.size());//2
    }

}
