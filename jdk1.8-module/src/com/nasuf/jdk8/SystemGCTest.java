package com.nasuf.jdk8;

public class SystemGCTest {

    public static void main(String[] args) {
        new SystemGCTest();
        /**
         * 提醒jvm的垃圾回收器执行GC行为，但无法确保GC一定执行
         * 因此finalize()方法也不一定被执行
         */
        System.gc();
        /**
         * 强制调用失去引用的对象的finalize()方法
         */
        System.runFinalization();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("SystemGCTest 重写了 finalize()");
    }
}
