package com.atguigu.java;

/**
 * 线程安全的懒汉式单例
 *
 * @author Meiko
 * @create 2021-05-12 20:40
 */
public class Singleton {

    private static Singleton INSTANCE = null;

    private Singleton() {

    }

    // 方式一：
//    public static final Singleton INSTANCE = new Singleton();

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }
        }

        return INSTANCE;
    }
}
