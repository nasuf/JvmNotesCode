package com.nasuf.jdk8;

public class OperandStackTest {

    public void testAddOperation() {
        // byte, short, boolean, char都以int型进行保存
        byte i = 15;
        int j = 8;
        int k = i + j;
    }

    public int getSum() {
        int m = 1;
        int n = 2;
        int k = m + n;
        return k;
    }

    public int testGetSum() {
        int i = getSum();
        return i;
    }
}
