package com.zlm;

/**
 * @author Kakrolot
 * @date 2021/6/22 23:07
 */
public class ThreadDay2{
    public static void main(String[] args) {
        RunableImplement runableImplement = new RunableImplement();
        new Thread(runableImplement,"阿伟").start();
        new Thread(runableImplement,"黄牛").start();
        new Thread(runableImplement,"阿龙").start();
    }


}

class RunableImplement implements Runnable{

    private int ticketNum = 10;

    @Override
    public void run() {
        while(true){
            if(ticketNum<=0){
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"获取第"+ ticketNum-- +"票");
        }

    }
}




