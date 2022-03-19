package com.nasuf.jdk8;

public class DeadThreadTest {

    public static void main(String[] args) {
        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName() + " start");
            DeadThread dead = new DeadThread();
            System.out.println(Thread.currentThread().getName() + " end");
        };
        Thread t1 = new Thread(r, "thread 1");
        Thread t2 = new Thread(r, "thread 2");
        t1.start();
        t2.start();
    }
}

class DeadThread {
    static {
        if (true) {
            System.out.println(Thread.currentThread().getName() + " initialize current class");
            while (true) {
            }
        }
    }
}
