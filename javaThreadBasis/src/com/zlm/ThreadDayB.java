package com.zlm;

import java.util.Random;

/**
 * @author Kakrolot
 * @date 2021/6/28 13:44
 */
public class ThreadDayB implements Runnable{
    public int total;

    public int count;

    public ThreadDayB() {
        total = 100;
        count = 0;
    }

    public void run() {
        while (total > 0) {
            synchronized (this) {
                System.out.println(this);
                if(total > 0){
                    try {
                        Thread.sleep(new Random().nextInt(1000));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    count++;
                    total--;
                    System.out.println(Thread.currentThread().getName()+"\t当前票号:" + count);
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadDayB st = new ThreadDayB();
        for(int i=0;i<=5;i++){
            new Thread(st, "售票点" + i).start();
        }
    }



}
