package com.nasuf.jdk8;

public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader); // sun.misc.Launcher$AppClassLoader@135fbaa4

        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader); // sun.misc.Launcher$ExtClassLoader@2503dbd3

        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println(bootstrapClassLoader);  // null

        /**
         * 对于用户自定义类加载器，默认使用系统类加载器加载
         */
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader); // sun.misc.Launcher$AppClassLoader@135fbaa4

        /**
         * 系统核心类库，均使用引导类加载器加载
         */
        ClassLoader stringClassLoader = String.class.getClassLoader();
        System.out.println(stringClassLoader);  // null
    }
}
