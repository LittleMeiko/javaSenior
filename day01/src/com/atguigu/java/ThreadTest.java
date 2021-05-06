package com.atguigu.java;

/**
 * 创建线程:
 * 1.继承Thread重写run()
 * 2.实现runnable接口
 *
 * @author Meiko
 * @create 2021-05-06 20:41
 */
public class ThreadTest {

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        // start()的作用：1.启动当前线程 2.调用当前线程的run()
        t1.start();
        //t1.run();

        MyThread t2 = new MyThread();
        t2.start();

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i + "###main()###");
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
