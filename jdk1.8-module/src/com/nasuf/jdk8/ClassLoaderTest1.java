package com.nasuf.jdk8;

import sun.misc.Launcher;

import java.net.URL;

public class ClassLoaderTest1 {
    public static void main(String[] args) {
        System.out.println("-------------启动类加载器--------------");
        /**
         * 获取BootstrapClassLoader能够加载的api路径
         */
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL urL : urLs) {
            System.out.println(urL.toExternalForm());
        }

        System.out.println("-------------扩展类加载器--------------");
        /**
         * 获取ExtensionClassLoader能够加载的api路径
         */
        java.lang.String extDirs = System.getProperty("java.ext.dirs");
        for (String s : extDirs.split(":")) {
            System.out.println(s);
        }
    }
}
