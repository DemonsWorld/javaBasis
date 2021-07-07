package com.zlm;

/**
 * @author Kakrolot
 * @date 2021/6/24 20:54
 */
public class ThreadDay6 extends Thread {
    /**
     * @author Ice, You're very best
     * @date 2018/10/24 14:47
     * @desc 停止线程的错误方法interrupt()
     */

    public static void main(String[] args) {
        ThreadDay6 wrongWayToStop = new ThreadDay6();

        System.out.println("线程启动");
        wrongWayToStop.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("中断线程");
        wrongWayToStop.interrupt();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("111");
            e.printStackTrace();
        }
        System.out.println("线程结束");
    }

    @Override
    public void run() {
        while (!this.isInterrupted()) {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        }
        System.out.println("线程正确结束，执行收尾逻辑，如清理工作，关闭流或连接等");
    }

}
