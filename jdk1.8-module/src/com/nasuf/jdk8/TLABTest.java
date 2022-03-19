package com.nasuf.jdk8;

public class TLABTest {
    public static void main(String[] args) {
        System.out.println("testing...");
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void test() {
        Object o = new Object();
        // use v
        // ...
        o = null;
    }

    public static String createStringBuffer(String s1, String s2) {
        StringBuffer sb = new StringBuffer();
        sb.append(s1);
        sb.append(s2);
        return sb.toString();
    }
}
