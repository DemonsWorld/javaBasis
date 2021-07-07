package com.zlm;

/**
 * @description: 问题：现在有 T1、T2、T3 三个线程,怎样保证 T2 在 T1 执行完后执行T3在T2执行完
 * <p>
 * 分析：使用join方法实现
 * @author:wenhuohuo
 */

public class ThreadDay9 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> System.out.println("线程1运行"), "t1");

        Thread t2 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程2运行");
        }, "t2");

        Thread t3 = new Thread(() -> {
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程3运行");
        }, "t3");

        t3.start();

        t2.start();

        t1.start();

    }

}