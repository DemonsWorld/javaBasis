package com.zlm;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Kakrolot
 * @date 2021/7/7 15:28
 */
public class ThreadPoolDay1 {
    public static void main(String[] args) {
        //创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
        newCachedThreadPoolTest();
        //创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
        //创建一个定长线程池，支持定时及周期性任务执行。
        //创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先

    }

    public static void newCachedThreadPoolTest(){
        ExecutorService cachedThreadPool  = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            int index = i;
            try {
                Thread.sleep(index*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index);
                }
            });
        }

    }
}
