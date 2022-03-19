package com.nasuf.jdk8;

/**
 * 题目：new String("ab")会创建几个对象？
 */
public class StringNewTest {
    public static void main(String[] args) {
//        String str = new String("ab");
        String str = new String("a") + new String("b");
    }
}
