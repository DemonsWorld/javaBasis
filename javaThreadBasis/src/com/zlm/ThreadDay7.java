package com.zlm;

/**
 * @author Ice, You're very best
 * @date 2018/10/24 14:47
 * @desc 停止线程的错误方法interrupt()
 */
public class ThreadDay7 extends Thread {

    public static void main(String[] args) {
        ThreadDay7 wrongWayToStop = new ThreadDay7();

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
            e.printStackTrace();
        }
        System.out.println("线程结束");
    }

    @Override
    public void run() {
        while (!this.isInterrupted()) {
            System.out.println("线程在运行中");//输出当前循环执行了多少次
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
        System.out.println("线程正确结束，执行收尾逻辑，如清理工作，关闭流或连接等");
    }
}
