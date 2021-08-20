package com.atguigu.java1;

import java.io.Serializable;

/**
 * @author Meiko
 * @date 2021-08-20
 */
public class Creature<T> implements Serializable {

    private char gender;
    public double weight;

    private void breath() {
        System.out.println("生物呼吸");
    }

    public void eat() {
        System.out.println("生物进食");
    }
}
