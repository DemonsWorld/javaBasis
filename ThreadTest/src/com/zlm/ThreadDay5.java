package com.zlm;

/**
 * @author Kakrolot
 * @date 2021/6/24 20:43
 */
public class ThreadDay5 implements Runnable {

    /**
     * @author Ice, You're very best
     * @date 2018/10/24 14:47
     * @desc 停止线程的正确方法
     */

    volatile boolean keepRunning = true;

    public static void main(String[] args) {
        ThreadDay5 wrongWayToStop = new ThreadDay5();
        Thread thread = new Thread(wrongWayToStop);

        System.out.println("线程启动");
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("中断线程");
        wrongWayToStop.keepRunning = false;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程结束");
    }

    @Override
    public void run() {
        while (keepRunning) {
            for (int i = 0; i < 10; i++) {
                System.out.println("线程在运行中" + i);//输出当前循环执行了多少次
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("线程正确结束，执行收尾逻辑，如清理工作，关闭流或连接等");
    }

}
