package com.nasuf.jdk8;

public class StringTest3 {

    public static void main(String[] args) {
        StringTest3 t = new StringTest3();
        t.test6();
    }

    public void test1() {
        String s1 = "a" + "b" + "c";
        String s2 = "abc";

        /**
         * 最终.java编译成.class，再执行.class
         * 将.class文件反编译可以看到如下语句：
         * String s1 = "abc";
         * String s2 = "abc";
         */
        System.out.println(s1 == s2);   // true
        System.out.println(s1.equals(s2));  // true
    }

    public void test2() {
        String s1 = "javaEE";
        String s2 = "hadoop";

        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";

        // 如果拼接符号的前后出现了变量，则相当于在堆空间中new String()
        // 具体的内容为拼接后的结果 "javaEEhadoop"
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4);   // true
        System.out.println(s3 == s5);   // false
        System.out.println(s3 == s6);   // false
        System.out.println(s3 == s7);   // false
        System.out.println(s5 == s6);   // false
        System.out.println(s5 == s7);   // false
        System.out.println(s6 == s7);   // false

        // intern(): 判断字符串常量池中是否存在javaEEhadoop值；如果存在，则返回常量池中该字符串的地址
        // 如果不存在，则在常量池中加载一份，并返回此对象的地址
        String s8 = s6.intern();
        System.out.println(s3 == s8);   // true
    }

    public void test3() {
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";

        /**
         * s1 + s2执行细节(变量s是为了解释方便，并非字节码定义)：
         * ① StringBuilder s = new StringBuilder();
         * ② s.append("a")
         * ③ s.append("b")
         * ④ s.toString() --> 约等于 new String("ab")
         *
         * 补充：在JDK5.0之后使用的是StringBuilder,在JDK5.0之前使用的是StringBuffer
         */
        String s4 = s1 + s2;
        System.out.println(s3 == s4); // false
    }

    public void test4() {
        final String s1 = "a";
        final String s2 = "b";
        String s3 = "ab";

        /**
         * 1. 字符串拼接操作不一定使用的都是StringBuilder
         * 如果拼接符号左右两边都是字符串常量或常量引用(final修饰),则仍然使用编译期优化，
         * 即非StringBuilder方式
         * 2. 针对final修饰类、方法、基本上数据类型、引用数据类型的量的结构时，能使用final修饰就尽量使用
         *
         * 由于s1和s2均由final修饰，实际上引用s1和s2不再是变量
         * 字节码反编译后:
         * String s4 = "ab";
         */
        String s4 = s1 + s2;
        System.out.println(s3 == s4); // true
    }

    public void test5() {
        String s1 = "javaEEhadoop";
        String s2 = "javaEE";
        String s3 = s2 + "hadoop";
        System.out.println(s1 == s3);   // false

        final String s4 = "javaEE";
        String s5 = s4 + "hadoop";
        System.out.println(s1 == s5);   // true
    }

    public void test6() {
        long start1 = System.currentTimeMillis();
        method1(100000);
        long end1 = System.currentTimeMillis();
        System.out.println("method1 花费的时间为：" + (end1 - start1) + "ms");

        long start2 = System.currentTimeMillis();
        method2(100000);
        long end2 = System.currentTimeMillis();
        System.out.println("method2 花费的时间为：" + (end2 - start2) + "ms");
    }

    public void method1(int highLevel) {
        String src = "";
        for (int i = 0; i < highLevel; i++) {
            /**
             * 1. 每次循环都会创建StringBuilder对象
             * 2. toString()时又会创建new String()对象
             */
            src = src + "a";
        }
    }

    /**
     * 改进的空间：在实际开发中，如果基本确定要前前后后后添加的字符串长度不高于某个限定值，
     * 建议使用构造器StringBuilder(int), 避免底层不断扩容。默认为16
     *
     * public StringBuilder() {
     *     super(16);
     * }
     * @param highLevel
     */
    public void method2(int highLevel) {
        StringBuilder builder = new StringBuilder(10000);    // 仅创建一个StringBuilder对象
        for (int i = 0; i < highLevel; i++) {
            builder.append("a");
        }
    }
}
