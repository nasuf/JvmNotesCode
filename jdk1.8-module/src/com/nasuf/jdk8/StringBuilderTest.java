package com.nasuf.jdk8;

/**
 * StringBuilder本身不是线程安全的
 */
public class StringBuilderTest {

    /**
     * s1在方法内部声明，只在方法内部使用，是线程安全的
     */
    public static void method1() {
        StringBuilder s1 = new StringBuilder();
        s1.append("a");
        s1.append("b");
        // ...
    }

    /**
     * s2由方法外部传入，不是线程安全的
     */
    public static void method2(StringBuilder s2) {
        s2.append("a");
        s2.append("b");
    }

    /**
     * s3由方法返回，可能被其他线程调用，不是线程安全的
     */
    public static StringBuilder method3() {
        StringBuilder s3 = new StringBuilder();
        s3.append("a");
        s3.append("b");
        return s3;
    }

    /**
     * s4是线程安全的, 查看StringBuilder的toString()方法源码如下，实际上是返回了一个新String对象
     * 该对象本身是线程不安全的，因为返回给外部，会被其他线程调用
     *     @Override
     *     public String toString() {
     *         // Create a copy, don't share the array
     *         return new String(value, 0, count);
     *     }
     */
    public static String method4() {
        StringBuilder s4 = new StringBuilder();
        s4.append("a");
        s4.append("b");
        return s4.toString();
    }
}
