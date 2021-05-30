package com.atguigu.java;

/**
 * 用于测试Comparable比较器
 *
 * @author Meiko
 * @create 2021-05-30 16:39
 */
public class Goods implements Comparable{

    private String name;
    private double price;

    public Goods() {

    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof  Goods) {
            Goods goods = (Goods)o;
            if (this.price > goods.price) {
                return 1;
            } else if (this.price < goods.price){
                return -1;
            } else {
                return this.name.compareTo(goods.name);
            }
        }

        throw new RuntimeException("传入的参数不一致");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
