package com.nasuf.jdk8;

import java.util.ArrayList;

/**
 * -Xms60m -Xmx60m
 */
public class GCLOGTEST {
    public static void main(String[] args) {
        ArrayList<byte[]> list = new ArrayList<>();

        for (int i = 0; i < 500; i++) {
            byte[] arr = new byte[1024 * 100]; // 100KB
            list.add(arr);
        }
    }
}
