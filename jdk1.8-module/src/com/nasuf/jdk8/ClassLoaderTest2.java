package com.nasuf.jdk8;

public class ClassLoaderTest2 {
    public static void main(String[] args) {
        String[] arrStr = new String[10];
        System.out.println(arrStr.getClass()); // class [Ljava.lang.String;
        System.out.println(arrStr.getClass().getClassLoader()); // null，表示使用的是引导类加载器

        ClassLoaderTest2[] arr = new ClassLoaderTest2[10];
        System.out.println(arr.getClass()); // class [Lcom.nasuf.jdk8.ClassLoaderTest2;
        System.out.println(arr.getClass().getClassLoader()); // sun.misc.Launcher$AppClassLoader@135fbaa4

        int[] arrInt = new int[10];
        System.out.println(arrInt.getClass()); // class [I
        System.out.println(arrInt.getClass().getClassLoader()); // null，基本数据类型，表示不需要类加载器
    }
}
