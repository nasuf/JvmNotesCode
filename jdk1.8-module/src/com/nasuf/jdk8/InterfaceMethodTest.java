package com.nasuf.jdk8;

public class InterfaceMethodTest {
    public static void main(String[] args) {
        AA aa = new BB();
        aa.method2();
        AA.method1();
    }
}

interface AA {
    public static void method1() { }

    public default void method2() { }
}

class BB implements AA { }


