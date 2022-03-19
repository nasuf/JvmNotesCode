package com.nasuf.jdk8;

import java.util.Date;

public class MethodInvokeReturnTest {

    public void invoke1() {
        // 类实例构造器方法<init>()
        Date date = new Date();
        Thread t1 = new Thread();
        // 父类方法
        super.toString();
        // 私有方法
        methodPrivate();
    }

    private void methodPrivate() { }

    public void invoke2() {
        methodStatic();
    }

    public static void methodStatic() { }

    public void invoke3() {
        Thread t1 = new Thread();
        ((Runnable) t1).run();

        Comparable<Integer> com = null;
        com.compareTo(123);
    }

    public void invoke4() {
        System.out.println("hello");
        Thread t1 = null;
        t1.run();
    }

    public int returnInt() {
        int i = 500;
        return i;
    }

    public double returnDouble() {
        return 0.0;
    }

    public String returnString() {
        return "hello, world";
    }

    public int[] returnArr() {
        return null;
    }

    public float returnFloat() {
        int i = 10;
        return i;
    }

    public byte returnByte() {
        return 0;
    }
}