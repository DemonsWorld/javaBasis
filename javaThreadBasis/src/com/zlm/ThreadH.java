package com.zlm;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Kakrolot
 * @date 2021/6/30 21:55
 */
public class ThreadH {
    public static void main(String[] args) {
        TestLock2 t = new TestLock2();
        new Thread(t, "A").start();
        new Thread(t, "B").start();
        new Thread(t, "C").start();
    }
}

class TestLock2 implements Runnable {

    int ticketnums = 100;

    //定义lock
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {

            while (true) {

                lock.lock();

                if (ticketnums > 0) {

                    System.out.println(Thread.currentThread().getName() + "获得" + ticketnums--);
                } else {
                    break;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                lock.unlock();
            }
    }
}
