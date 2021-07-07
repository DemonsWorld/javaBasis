package com.zlm;

/**
 * @author Kakrolot
 * @date 2021/6/23 22:54
 */
public class ThreadDay4 {
    public static void main(String[] args) {
        MyYield myYield = new MyYield();
        new Thread(myYield,"a").start();
        new Thread(myYield,"B").start();


    }

}

class MyYield implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" start");
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+" finish");
    }
}



