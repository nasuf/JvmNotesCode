package com.nasuf.jdk8;

import java.lang.reflect.Method;

public class LoopRun {
    public static void main(String[] args) {
        while(true) {
            try {
                // 创建自定义类加载器的实例
                MyClassLoader loader
                        = new MyClassLoader("/Users/nasuf/Project/JvmNotesCode/jdk1.8-module/src/");
                // 加载指定的类
                Class<?> clazz = loader.findClass("com.nasuf.jdk8.Demo1");
                // 创建运行时类的实例
                Object demo = clazz.newInstance();
                // 获取运行时类中指定的方法
                Method m = clazz.getMethod("hot");
                // 调用指定的方法
                m.invoke(demo);
                Thread.sleep(5000);
            } catch (Exception e) {
                System.out.println("Not Found");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
