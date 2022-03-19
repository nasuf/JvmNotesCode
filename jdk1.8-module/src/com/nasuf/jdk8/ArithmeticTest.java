package com.nasuf.jdk8;

public class ArithmeticTest {

    public void method1() {
        int i = 10;
        // int j = i / 0;  // java.lang.ArithmeticException: / by zero
        double j = i / 0.0;
        System.out.println(j);  // Infinity

        double d1 = 0.0;
        double d2 = d1 / 0.0;
        System.out.println(d2); // NaN
    }

    public void method2() {
        float i = 10;
        float j = -i;
        i = -j;
    }

    public void method3() {
        int i = 100;
        i += 10;
    }

    public int method4() {
        int a = 80;
        int b = 7;
        int c = 10;
        return (a + b) * c;
    }

    public int method5(int i, int j) {
        return ((i + j - 1) & ~(j - 1));
    }

    public void method6() {
        int i = 10;
        ++i;
    }

    public void method7() {
        int i = 10;
        i++;
    }

    public void method8() {
        int i = 10;
        int a = i++;

        int j = 20;
        int b = ++j;
    }

    public void method9() {
        int i = 10;
        i = i++;
        System.out.println(i);
    }

    public static void main(String[] args) {
        ArithmeticTest test = new ArithmeticTest();
        test.method1();
    }

}
