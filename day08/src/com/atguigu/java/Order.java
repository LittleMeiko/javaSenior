package com.atguigu.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 自定义泛型：
 *    泛型类、泛型接口；泛型方法
 *    异常类不能是泛型的
 *    静态方法中不能使用类的泛型
 *
 * @author Meiko
 * @date 2021-07-27
 */
public class Order<T> {

    String orderName;
    int orderId;
    T orderT;

    public Order() {
        // 编译不通过
        // T[] arr = new T[10];
        // 编译通过
        T[] arr = (T[]) new Object[10];
    }

    public Order(String orderName,int orderId, T orderT) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    public T getOrderT() {
        return this.orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    /**
     * 泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系
     *
     * @param arr
     * @param <E>
     * @return
     */
    public static <E> List<E> copyArrayToList(E[] arr) {
        ArrayList<E> list = new ArrayList<>();
        for (E e : arr) {
            list.add(e);
        }

        return list;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }
}
