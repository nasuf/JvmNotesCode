package com.nasuf.jdk8;

import java.lang.ref.SoftReference;

/**
 * -Xmx10m -Xms10m
 */
public class SoftReferenceTest {

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
        // 创建对象，建立软引用
        /**
         * User user = new User(1, "nasuf");
         * SoftReference<User> userSoftReference = new SoftReference<>(user);
         * user = null; // 取消强引用
         *
         * 以下一行代码等价于以上三行代码
         */
        SoftReference<User> userSoftReference = new SoftReference<>(new User(1, "nasuf"));
        /**
         * 从软引用中重新获得强引用对象
         * 由于堆空间内存足够，所以不会回收软引用的可达对象
         */
        System.out.println(userSoftReference.get());

        System.gc();
        System.out.println("After GC:");
        System.out.println(userSoftReference.get());

        try {
            // 让系统认为内存资源紧张
            byte[] b = new byte[1024 * 1024 * 7];
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            /**
             * 再次从软引用中获取数据
             * 在抛出OOM之前，垃圾回收器会回收软引用的可达对象
             */
            System.out.println(userSoftReference.get());
        }
    }
}
