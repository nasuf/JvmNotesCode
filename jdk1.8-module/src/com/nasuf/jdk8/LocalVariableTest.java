package com.nasuf.jdk8;

import java.util.Date;

public class LocalVariableTest {
    private int count = 0;

    public static void main(String[] args) {
        LocalVariableTest test = new LocalVariableTest();
        int num = 10;
        test.test1();
    }

    public void test1() {
        Date date = new Date();
        String name1 = "nasuf";
        String info = test2(date, name1);
        System.out.println(date + name1);
    }

    public String test2(Date dateP, String name2) {
        dateP = null;
        name2 = "nasuf_test";
        double weight = 130;    // double类型占据2个slot
        char gender = '男';
        return dateP + name2;
    }

    public void test3() {
        count ++;
    }

    public void test4() {
        int a = 0;
        {
            int b = 0;
            b = a + 1;
        }
        // 变量c占据之前已经销毁的变量b占据的slot位置
        int c = a + 1;
    }

}
