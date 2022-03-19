package com.nasuf.jdk8;

public class StackOverflowTest {

    private static int i = 1;

    public static void main(String[] args) {
        System.out.println(i);
        i++;
        main(args);
    }

}
