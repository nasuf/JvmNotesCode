package com.nasuf.jdk8;

/**
 * -Xms60m -Xmx60m -XX:NewRatio=2 -XX:SurvivorRatio=8
 * -XX:+PrintGCDetails
 * => Eden: 16m, Survivor0/Survivor1: 2m, Old: 40m
 */
public class YoungOldSpaceTest {
    public static void main(String[] args) {
        byte[] buffer = new byte[1024 * 1024 * 20]; // 20m
    }
}
