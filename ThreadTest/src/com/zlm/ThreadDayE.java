package com.zlm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kakrolot
 * @date 2021/6/28 22:23
 */
public class ThreadDayE {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                synchronized (list){
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        Thread.sleep(3000);
        System.out.println(list.size());
    }
}


