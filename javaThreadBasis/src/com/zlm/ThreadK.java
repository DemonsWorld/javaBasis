package com.zlm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Kakrolot
 * @date 2021/7/5 22:24
 */
public class ThreadK {
    public static void main(String[] args) throws InterruptedException {
        Long start = System.currentTimeMillis();
        final Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    synchronized (list) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        list.add(random.nextInt());
                    }
                }
            };
            thread.start();
           // thread.join();
        }

        Thread.sleep(2000);

        System.out.println(list.size());

    }
}
