package com.nasuf.jdk8;

public class StackFrameTest {
    public static void main(String[] args) {
        StackFrameTest test = new StackFrameTest();
        test.method1();
    }

    public void method1() {
        System.out.println("method1()开始执行");
        method2();
        System.out.println("method1()执行结束");
    }

    public int method2() {
        System.out.println("method2()开始执行");
        int i = 10;
        int j = (int) method3();
        System.out.println("method2()即将结束");
        return i + j;
    }

    public double method3() {
        System.out.println("method3()开始执行");
        double j = 20.0;
        System.out.println("method3()即将结束");
        return j;
    }

}
