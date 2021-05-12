package com.atguigu.java;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全的方式二：Lock锁---JDK5.0新增
 * 比较常用的是Lock接口的实现类ReentrantLock
 *
 * 面试题：synchronized与Lock的区别
 *     1.Lock是显式锁，需要手动开启和关闭锁；synchronized是隐式锁，出了作用域自动释放。
 *     2.Lock只有代码块锁，synchronized有代码块锁和方法锁
 *     3.使用Lock锁，JVM将花费较少的时间来调度线程，性能更好。并且具有更好的扩展性（提供更多的子类）
 *
 * @author Meiko
 * @create 2021-05-12 21:14
 */
public class LockTest {

    public static void main(String[] args) {
        Window3 w = new Window3();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window3 implements Runnable {

    private int ticket = 100;

    // 1.实例化Lock,两种构造方法：①无参：线程争抢同步锁不排队 ②有参：boolean fair,线程排队不争抢同步锁
    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {

        while (true) {
            try {
                // 2.调用加锁方法lock()
                lock.lock();

                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);

                    ticket--;
                } else {
                    break;
                }
            }finally {
                // 3.调用解锁方法unlock()
                lock.unlock();
            }
        }
    }
}
