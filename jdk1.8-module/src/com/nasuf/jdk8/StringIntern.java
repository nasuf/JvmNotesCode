package com.nasuf.jdk8;

/**
 * 如何保证变量s指向的是字符串常量池中的数据呢？有两种方式：
 * 方式一：String s = "hello"，即使用字面量的定义方式
 * 方式二：调用intern()方法，例如：
 *        String s = new String("hello").intern();
 *        String s = new StringBuilder("hello").toString().intern()
 */
public class StringIntern {
    public static void main(String[] args) {
        String s1 = new String("1");
        s1.intern();    // 调用此方法之前，字符串常量池中已经存在"1"
        String s2 = "1";
        /**
         * JDK6 -> false
         * JDK7及以后 -> false
         *
         * 不论字符串常量池在不同版本JDK中的位置不同，s1指向的是堆空间中创建的String对象，
         * 而s2指向的是字符串常量池中的字符串对象"1",因此对象地址不会相同，均返回false
         */
        System.out.println(s1 == s2);

        /**
         * 此处s3变量记录的地址为new String("11")的地址
         * 而该行代码执行完毕后，字符串常量池中并不存在"11"常量（与JDK版本无关）
         */
        String s3 = new String("1") + new String("1");
        /**
         * 该行代码执行后，会在字符串常量池中生成"11"
         * JDK6 -> 常量池在方法区；在字符串常量池中创建了一个新的对象"11"，也就有一个新的地址
         * JDK7 -> 常量池在堆空间中；此时常量池中并没有创建"11"对象，而是创建了一个指向堆空间中new String("11")的地址
         */
        s3.intern();
        /**
         * s4变量记录的地址是上一行代码执行后在常量池中生成的"11"的地址,
         * 而常量池中"11"的地址此时指向的是堆空间中new String("11")的地址
         */
        String s4 = "11";
        /**
         * JDK6 -> false
         * JDK7及以后 -> true
         */
        System.out.println(s3 == s4);
    }
}
