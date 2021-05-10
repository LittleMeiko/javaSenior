package com.atguigu.java;

/**
 * 创建多线程的方式2：实现runnable接口
 *
 * @author Meiko
 * @create 2021-05-10 21:19
 */
public class ThreadTest1 {

    public static void main(String[] args) {
        MThread mThread = new MThread();
        Thread t1 = new Thread(mThread);
        t1.setName("线程1");
        t1.start();

        Thread t2 = new Thread(mThread);
        t2.setName("线程2");
        t2.start();
    }
}

class MThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
