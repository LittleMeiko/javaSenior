package com.atguigu.java1;

import com.atguigu.java.User;
import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Meiko
 * @date 2021-07-01
 */
public class TreeSetTest {

    @Test
    public void test2() {
        Comparator comparator = new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User) {
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return -Integer.compare(u1.age, u2.age);
                } else {
                    throw new RuntimeException("传入的数据类型不匹配!");
                }
            }
        };

        Set set1 = new TreeSet(comparator);
        set1.add(new User("Cita", 56));
        set1.add(new User("Aida", 23));
        set1.add(new User("Jerry", 78));
        set1.add(new User("Tom", 12));
        set1.add(new User("Banana", 46));
        set1.add(new User("Meiko", 46));

        Iterator iterator1 = set1.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
    }

    /**
     * 1.向TreeSet添加数据时，要求是相同类的对象
     * 2.两种排序方式：自然排序(Comparable)、定制排序(Comparator接口)
     *      自然排序：比较两个对象是否相等的标准为compareTo()方法返回0，而不再是equals()
     *      定制排序：比较两个对象是否相等的标准为compare()方法返回0，而不再是equals()
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

        System.out.println("*************");

        Set set1 = new TreeSet();
        set1.add(new User("Cita", 12));
        set1.add(new User("Aida", 12));
        set1.add(new User("Jerry", 12));
        set1.add(new User("Tom", 12));
        set1.add(new User("Banana", 12));

        Iterator iterator1 = set1.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
    }
}
