package com.nasuf.jdk8;

public class HelloApp {

    /**
     * prepare阶段只会赋值为0；initialization阶段赋值为1
     */
    private static int a = 1;

    static {
        a = 2;
        b = 20;
        // Error: Illegal Forward Reference
        // System.out.println(b);
    }

    private static int b = 10;

    public static void main(String[] args) {
        System.out.println(a); // 2
        System.out.println(b); // 10
    }
}
