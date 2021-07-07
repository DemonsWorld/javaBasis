package com.zlm;

/**
 * @author Kakrolot
 * @date 2021/6/27 13:45
 */
public class ThreadDay8 extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("子线程中执行的方法");
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadDay8 t8 = new ThreadDay8();
        System.out.println("111");
        t8.start();
        System.out.println("222");
        t8.join();
        System.out.println("333");

    }
}
