package com.zlm;

/**
 * @author Kakrolot
 * @date 2021/6/29 20:40
 * 死锁，多个线程抱着对方需要的资源，然后形成僵持
 */
public class ThreadDayG {
    public static void main(String[] args) {
//        A a = new A(1);
//        A a1 = new A(2);
//        a.getCount();
//        a1.getCount();

        ThreadTool t1 = new ThreadTool("1","老刘");
        ThreadTool t2 = new ThreadTool("2","老李");
        t1.start();
        t2.start();
    }
}

class ThreadTool extends Thread{
    static A a = new A();
    static B b = new B();

    private String id;
    private String name;

    public ThreadTool(String id,String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public void run() {
        if(name.equals("老刘")){
            synchronized (a){
                System.out.println(this.name+"获得锁A");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b){
                    System.out.println(this.name+"获得锁B");
                }
            }
        }else{
            synchronized (b){
                System.out.println(this.name+"获得锁B");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a){
                    System.out.println(this.name+"获得锁a");
                }
            }

        }
    }
}


class B {
    private static int count;

    public B(int a) {
        count = a;
    }

    public void getCount(){
        System.out.println(count);
    }

    public B() {
    }
}

class A {
    private static int count;

    public A(int a) {
        count = a;
    }

    public void getCount(){
        System.out.println(count);
    }

    public A() {
    }
}



