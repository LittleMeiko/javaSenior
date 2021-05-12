package com.atguigu.java;

/**
 * 死锁：不同的线程分别占用对方需要的同步资源不放弃，都在等待对方放弃自己需要的同步
 *        资源，就形成了线程的死锁。
 *
 * @author Meiko
 * @create 2021-05-12 20:47
 */
public class DeadLockTest {

    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();

        new Thread(){
            @Override
            public void run() {
                synchronized (s1) {
                    s1.append("a");
                    s2.append("1");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (s2) {
                        s1.append("2");
                        s2.append("b");
                    }
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s2) {
                    s1.append("c");
                    s2.append("3");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (s1) {
                        s1.append("4");
                        s2.append("d");
                    }
                }
            }
        }).start();
    }
}
