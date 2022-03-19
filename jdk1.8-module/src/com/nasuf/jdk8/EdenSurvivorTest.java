package com.nasuf.jdk8;

/**
 * -Xms600m -Xmx600m
 * -XX:-UseAdaptiveSizePolicy
 */
public class EdenSurvivorTest {
    public static void main(String[] args) {
        System.out.println("testing...");
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
