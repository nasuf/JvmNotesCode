package com.nasuf.jdk8;

import java.lang.ref.WeakReference;

public class WeakReferenceTest {
    public static class User {

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int id;
        public String name;

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        // 构造弱引用
        WeakReference<User> weakReference = new WeakReference<>(new User(1, "nasuf"));
        // 从弱引用中重新获取对象
        System.out.println(weakReference.get());
        System.gc();
        // 不管当前你内存空间是否足够，都会回收它的内存
        System.out.println("After GC:");
        // 重新尝试从弱引用中获取对象
        System.out.println(weakReference.get());
    }

}
