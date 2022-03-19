package com.nasuf.jdk8;

public class ClassCastTest {

    public static void main(String[] args) {
        ClassCastTest classCastTest = new ClassCastTest();
        classCastTest.downCast4();
    }

    public void upCast1() {
        int i = 10;
        long l = i;
        float f = i;
        double d = i;

        float f1 = l;
        double d1 = l;
        double d2 = f1;
    }

    public void upCast2() {
        int i = 123_123_123;
        float f = i; // 1.2312312E8, 精度损失
        System.out.println(f);

        long l = 123_123_123_123_123_123L;
        double d = l;
        System.out.println(d); // 1.2312312312312312E17, 精度损失
    }

    public void upCast3(byte b) {
        int i = b;
        long l = b;
        double d = b;
    }

    public void upCast4(short s) {
        int i = s;
        long l = s;
        float f = s;
    }

    public void downCast1() {
        int i = 10;
        byte b = (byte) i;
        short s = (short) i;
        char c = (char) i;

        long l = 10L;
        int i1 = (int) l;
        byte b1 = (byte) l;
    }

    public void downCast2() {
        short s = 10;
        byte b = (byte) s;

        byte b1 = 20;
        short s1 = (byte) b1;
    }

    public void downCast3() {
        int i = 128;
        byte b = (byte) i;
        System.out.println(b);  // -128
    }

    public void downCast4() {
        double d1 = Double.NaN;
        int i = (int) d1;
        System.out.println(i);  // 0

        double d2 = Double.POSITIVE_INFINITY;
        long l = (long) d2;
        int j = (int) d2;
        float f = (float) d2;

        System.out.println(l);  // 9223372036854775807
        System.out.println(Long.MAX_VALUE); // 9223372036854775807
        System.out.println(j);  // 2147483647
        System.out.println(Integer.MAX_VALUE);  // 2147483647
        System.out.println(f);  // Infinity

        float f1 = (float) d1;
        System.out.println(f1); // NaN
    }

}
