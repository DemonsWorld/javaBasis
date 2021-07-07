package com.zlm;

/**
 * @author Kakrolot
 * @date 2021/6/29 14:37
 */
public class ThreadDayF {
    public static void main(String[] args) {
       Station station = new Station();
        new Thread(station,"游客1").start();
        new Thread(station,"游客2").start();
        new Thread(station,"游客3").start();
    }
}

class Station implements Runnable{

    private int ticketNum = 10;
    private boolean flag = true;

    private String a;

    @Override
    public void run() {
        while(flag) {
            synchronized (this) {
                if (ticketNum <= 0) {
                    flag = false;
                    return;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " get No " + ticketNum--);
            }
        }
    }
}
