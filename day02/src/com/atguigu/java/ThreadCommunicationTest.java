package com.atguigu.java;

/**
 * 线程通信
 *
 * 涉及到的三个方法：
 *  1.wait()：使用此方法使当前线程进入阻塞状态，会释放锁(同步监视器)
 *  2.notify()：唤醒一个被wait的线程，如果有多个线程被wait，那么就唤醒优先级最高的线程
 *  3.notifyAll()：唤醒所有被wait的线程
 *
 * 注意点：
 *  1.上面三个方法都必须使用在同步块或者同步方法中
 *  2.上面三个方法的调用者都必须是同步代码块或者同步方法中的同步监视器，否则会抛 IllegalMonitorStateException 异常
 *  3.上面三个方法都是定义在java.Object.lang类中的，并非定义在Thread类中
 *
 * 面试题：sleep() 与 wait()的区别？
 *  相同点：都可以使线程进入阻塞状态
 *  不同点：1.声明的位置不同：sleep()是声明在Thread类中的，wait()是声明在Object类中的
 *          2.调用要求不同：sleep()可以在任何需要的场景下调用，wait()只能在同步代码块或者同步方法中调用
 *          3.关于是否释放锁：如果两个方法都使用在同步块或者同步方法中，sleep()不会释放锁，wait()会释放锁
 *
 * @author Meiko
 * @create 2021-05-16 16:19
 */
public class ThreadCommunicationTest {

    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}

class Number implements Runnable {

    private int number = 1;
    private Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                /*
                 * 唤醒1个等待的线程,如果有多个线程被wait(),就唤醒优先级最高的那个线程
                 * notifyAll()：一旦执行此方法就会唤醒所有被wait()的线程
                 * 这两个方法必须使用在同步块或同步方法中
                 */
                //this.notify();
                obj.notify();

                if (number <= 100) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    try {
                        //使用wait()方法使当前线程进入阻塞状态，wait()会释放锁，必须使用在同步块或者同步方法中
                        //this.wait();
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}
