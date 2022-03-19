package com.nasuf.jdk8;

public class ClassInitTest {
    private static int num1 = 1;
    private static int num2 = 10;
    static {
        num1 = 2;
        num2 = 20;
    }

    public static void main(String[] args) {
        System.out.println(ClassInitTest.num1);
        System.out.println(ClassInitTest.num2);
    }
}
