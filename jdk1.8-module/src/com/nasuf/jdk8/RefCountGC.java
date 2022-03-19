package com.nasuf.jdk8;

/**
 * -XX:+PrintGCDetails
 */
public class RefCountGC {

    // 这个成员属性唯一的作用就是占用5MB内存空间
    private byte[] bigSize = new byte[5 * 1014 * 1024]; // 5MB
    Object reference = null;

    public static void main(String[] args) {
        RefCountGC obj1 = new RefCountGC();
        RefCountGC obj2 = new RefCountGC();

        obj1.reference = obj2;
        obj2.reference = obj1;

        obj1 = null;
        obj2 = null;

        /**
         * 显式执行垃圾回收行为
         * 这里发生GC, obj1和obj2都能被回收
         */
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.gc();
    }

}
