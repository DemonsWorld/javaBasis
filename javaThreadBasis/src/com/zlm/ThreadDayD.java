package com.zlm;

/**
 * @author Kakrolot
 * @date 2021/6/28 20:03
 * 测试线程优先级
 */
public class ThreadDayD {

    public static void main(String[] args) {
        //主线程默认优先级
        System.out.println(Thread.currentThread().getName()+" "+Thread.currentThread().getPriority());

        Mypriority mypriority = new Mypriority();

        Thread t = new Thread(mypriority);
        Thread t1 = new Thread(mypriority);
        Thread t2 = new Thread(mypriority);
        Thread t3 = new Thread(mypriority);
        Thread t4 = new Thread(mypriority);
        Thread t5 = new Thread(mypriority);

        t1.start();

        t2.setPriority(1);
        t2.start();

        t3.setPriority(4);
        t3.start();

        t4.setPriority(Thread.MAX_PRIORITY);
        t4.start();

        //t5.setPriority(-1);

    }


}

class Mypriority implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" "+Thread.currentThread().getPriority());
    }
}