package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 增强for循环(for each)遍历集合：内部仍然调用的是迭代器
 *
 * @author Meiko
 * @create 2021-06-02 21:56
 */
public class ForEachTest {

    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",20));

        for (Object obj : coll){
            System.out.println(obj);
        }
    }

    @Test
    public void exer1() {
        String[] strs = new String[]{"MM","MM","MM"};

//        for (int i = 0; i < strs.length; i++) {
//            strs[i] = "GG";
//        }
//        for (int i = 0; i < strs.length; i++) {
//            System.out.print(strs[i] + " ");
//        }

        for (String str : strs) {
            str = "GG";
        }
        for (String str : strs) {
            System.out.print(str + " ");
        }

    }
}
