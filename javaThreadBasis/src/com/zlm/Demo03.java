package com.zlm;
/**
 * 使用异常，停止线程
 * @author 温暖wk
 * 结论：能正确停止线程，且for循环后面的语句不会执行
 * 使用抛出异常的方法解决
 */
public class Demo03 extends Thread{

    @Override
    public void run() {
        for(int i=0;i<500000;i++) {//只有循环足够多，才能看到线程停止
            if(this.interrupted()) {//用Threa.interrupted有什么不同？
                System.out.println("已经是停止状态了！我要退出");
                break;  //for循环后面如果有语句会继续执行

            }
            System.out.println("i="+(i+1));
        }
    }

    public static void main(String[] args) {
        Demo03 t3=new Demo03();
        t3.start();   //启动一个线程
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        t3.interrupt();
        System.out.println("end");
    }

}