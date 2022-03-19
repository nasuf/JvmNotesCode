package com.nasuf.jdk8;

public class StringTest1 {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        String s1 = "abc";  // 字面量定义的方式，"abc"存储在字符串常量池中
        String s2 = "abc";
        System.out.println(s1 == s2); // 判断地址 true

        s1 = "hello";
        System.out.println(s1 == s2); // 判断地址 false
        System.out.println(s1); // "hello"
        System.out.println(s2); // "abc"
    }

    public static void test2() {
        String s1 = "abc";
        String s2 = "abc";
        s2 += "def";
        System.out.println(s2); // "abcdef"
        System.out.println(s1); // "abc"
    }

    public static void test3() {
        String s1 = "abc";
        String s2 = s1.replace('a', 'm');
        System.out.println(s1); // "abc"
        System.out.println(s2); // "mbc"
    }

}
