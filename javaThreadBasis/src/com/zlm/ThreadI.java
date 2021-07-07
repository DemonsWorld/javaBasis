package com.zlm;

/**
 * @author Kakrolot
 * @date 2021/7/1 20:00
 * 测试：生产者消费者模型，；利用缓冲区解决
 */
class ThreadI{

    public static void main(String[] args) {
        SyncContainer container = new SyncContainer();
        new Productor(container).start();
        new Consumer(container).start();

    }
}

class Productor extends Thread{
    SyncContainer syncContainer;
    public Productor(SyncContainer container){
        this.syncContainer = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            syncContainer.push(new Chicken(i));
            System.out.println("生产了"+i+"只鸡");
        }
    }
}

class Consumer extends Thread{
    SyncContainer syncContainer;
    public Consumer(SyncContainer container){
        this.syncContainer = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了 " + syncContainer.pop().id+"只鸡");
        }
    }
}

class Chicken {
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}

class SyncContainer{

    Chicken[] chickens = new Chicken[10];

    int count = 0;

    //生产者生产产品
    public synchronized void push(Chicken chicken){
        if(count == chickens.length){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        chickens[count] = chicken;
        count++;

        this.notifyAll();

    }

    //消費者消費产品
    public synchronized Chicken pop(){
        if(count == 0 ){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        count--;
        Chicken chicken = chickens[count];

        this.notifyAll();
        return chicken;
    }



}