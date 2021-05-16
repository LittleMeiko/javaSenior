package com.atguigu.java;

import org.omg.Messaging.SyncScopeHelper;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三：实现Callable接口 ---> JDK5.0以后新增的
 *
 * 相比实现Runnable接口方式的优势：
 *  1.相比run(),call()可以有返回值
 *  2.call()可以抛出异常
 *  3.call()支持泛型的返回值
 *  4.此方式需要借助FutureTask类，比如获取返回值
 *
 * @author Meiko
 * @create 2021-05-16 17:54
 */
public class CallableTest {

    public static void main(String[] args) {
        NumThread numThread = new NumThread();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(numThread);
        new Thread(futureTask).start();

        try {
            Integer sum = futureTask.get();
            System.out.println("总和为：" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class NumThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100 ; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }

        return sum;
    }
}
