package com.nasuf.jdk8;

public class SynchronizationTest {

    private int i = 0;
    public void add() {
        i++;
    }

    private Object obj = new Object();
    public void subtract() {
        synchronized (obj) {
            i--;
        }
    }

}
