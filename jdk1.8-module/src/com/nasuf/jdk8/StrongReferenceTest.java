package com.nasuf.jdk8;

/**
 * -XX:+PrintGCDetails
 */
public class StrongReferenceTest {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("Hello");
        StringBuffer str1 = str;

        str = null;
        System.gc();

        try {
            // sleep 3s 确保gc发生
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(str1);

    }
}
