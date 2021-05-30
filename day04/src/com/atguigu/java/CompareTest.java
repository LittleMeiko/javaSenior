package com.atguigu.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 对象比较：
 *  Comparable接口(自然排序)：实现此接口，重写compareTo()
 *
 *  Comparator接口(定制排序)：当某个类型的数据没有实现Comparable接口，
 *                            或者实现了Comparable接口但其排序规则在某个场景下不适用时可使用此种排序
 *
 * @author Meiko
 * @create 2021-05-30 16:28
 */
public class CompareTest {

    @Test
    public void test1() {
        Goods[] goods = new Goods[5];
        goods[0] = new Goods("lenvoMouse" , 34);
        goods[1] = new Goods("huaweiMouse" , 65);
        goods[2] = new Goods("xiaomiMouse" , 12);
        goods[3] = new Goods("appleMouse" , 100);
        goods[4] = new Goods("dellMouse" , 65);

        Arrays.sort(goods);
        System.out.println(Arrays.toString(goods));
    }

    @Test
    public void test2() {
        String[] arr = new String[]{"AA","MM","HH","BB","CC","JJ"};
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);
                }

                throw new RuntimeException("传入的参数不是String类型的");
            }
        });

        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test3() {
        Goods[] goods = new Goods[6];
        goods[0] = new Goods("lenvoMouse" , 34);
        goods[1] = new Goods("huaweiMouse" , 65);
        goods[2] = new Goods("huaweiMouse" , 88);
        goods[3] = new Goods("xiaomiMouse" , 12);
        goods[4] = new Goods("appleMouse" , 100);
        goods[5] = new Goods("dellMouse" , 65);

        Arrays.sort(goods, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Goods && o2 instanceof Goods) {
                    Goods g1 = (Goods) o1;
                    Goods g2 = (Goods) o2;

                    if(g1.getName().equals(g2.getName())) {
                        return -Double.compare(g1.getPrice(), g2.getPrice());
                    }else{
                        return g1.getName().compareTo(g2.getName());
                    }
                }

                throw new RuntimeException("输入的数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(goods));
    }
}
