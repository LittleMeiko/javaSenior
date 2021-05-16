package com.atguigu.java;

import java.util.concurrent.*;

/**
 * 创建线程的方式四：线程池
 *
 * 使用线程池的好处：
 *  1.提高响应速度(减少了创建新线程的响应时间)
 *  2.降低资源消耗(重复利用线程池中的线程，不需要每次都新创建线程)
 *  3.便于线程管理(可以设置线程池的属性)
 *
 *
 *  面试题：创建线程的方式有几种？四种
 *          1.继承Thread类并重写run()
 *          2.实现Runnable接口并实现run()
 *          3.实现Callable接口并实现call()
 *          4.使用线程池
 *
 * @author Meiko
 * @create 2021-05-16 18:30
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        //设置线程池的属性
        ThreadPoolExecutor tpService = (ThreadPoolExecutor) service;
        tpService.setCorePoolSize(10);
//        tpService.setKeepAliveTime();
//        System.out.println(service.getClass());
        //execute()适用于Runnable
        service.execute(new NumberThread());

        //submit()适用于Callable
        Future future = service.submit(new NumberThread2());
        try {
            Object sum = future.get();
            System.out.println("100以内的奇数和为:" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        service.shutdown();
    }
}

class NumberThread2 implements Callable {

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100 ; i++) {
            if (i % 2 != 0) {
                sum += i;
                System.out.println(Thread.currentThread().getName() + ":" +i);
            }
        }
        return sum;
    }
}

class NumberThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <= 100 ; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" +i);
            }
        }
    }
}
