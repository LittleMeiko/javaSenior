package com.atguigu.java;

/**
 * 线程安全问题:
 *  1.同步代码块:
 *      synchronized(同步监视器) {
 *          //需要被同步的代码
 *      }
 *
 *  2.同步方法:
 *      public synchronized void method() {
 *          //需要被同步的代码
 *      }
 * @author Meiko
 * @create 2021-05-11 21:34
 */
public class WindowTest {

    public static void main(String[] args) {
        Window w = new Window();

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

class Window implements Runnable{

    private int ticket = 100;

    @Override
    public void run() {

        while(true){
            //此时的this:唯一的Window的对象   //方式二：synchronized (dog) {
            synchronized (this){

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
            }
        }
    }
}

class Dog{

}