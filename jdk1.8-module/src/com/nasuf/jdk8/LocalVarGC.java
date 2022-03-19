package com.nasuf.jdk8;

public class LocalVarGC {

    public void localVarGC1() {
        byte[] buffer = new byte[10 * 1014 * 1024];  // 10MB
        System.gc();
    }

    public void localVarGC2() {
        byte[] buffer = new byte[10 * 1014 * 1024];  // 10MB
        buffer = null;
        System.gc();
    }

    public void localVarGC3() {
        {
            byte[] buffer = new byte[10 * 1014 * 1024];  // 10MB
        }
        System.gc();
    }

    public void localVarGC4() {
        {
            byte[] buffer = new byte[10 * 1014 * 1024];  // 10MB
        }
        int value = 10;
        System.gc();
    }

    public void localVarGC5() {
        localVarGC1();
        System.gc();
    }

    public static void main(String[] args) {
        LocalVarGC localVarGC = new LocalVarGC();
        localVarGC.localVarGC5();
    }

}
