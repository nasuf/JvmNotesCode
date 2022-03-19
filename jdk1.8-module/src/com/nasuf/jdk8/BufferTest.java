package com.nasuf.jdk8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BufferTest {

    private static final String TO = "/Users/nasuf/Downloads/pycharm-community-2021.1.1.dmg";
    private static final int _100MB = 1024 * 1024 * 100;

    public static void main(String[] args) {
        long sum = 0;
        String src = "/Users/nasuf/Downloads/pycharm-community-2021.1.1.dmg";   // 文件大小：472.1 MB
        for (int i = 0; i < 3; i++) {
            String dest = "/Users/nasuf/Downloads/pycharm-community-2021.1.1." + i + "dmg";
//            sum += io(src, dest);   // 总花费时间为：3019
            sum += directBuffer(src, dest); // 总花费时间为：1647
        }
        System.out.println("总花费时间为：" + sum);
    }

    private static long directBuffer(String src, String dest) {
        long start = System.currentTimeMillis();

        FileChannel inChannel = null;
        FileChannel outChannel = null;

        try {
            inChannel = new FileInputStream(src).getChannel();
            outChannel = new FileOutputStream(dest).getChannel();

            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_100MB);
            while (inChannel.read(byteBuffer) != -1) {
                byteBuffer.flip();  // 修改为读数据模式
                outChannel.write(byteBuffer);
                byteBuffer.clear(); // 清空
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inChannel != null) {
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outChannel != null) {
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long io(String src, String dest) {
        long start =  System.currentTimeMillis();

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dest);
            byte[] buffer = new byte[_100MB];
            while (true) {
                int len = fis.read(buffer);
                if (len == -1) {
                    break;
                }
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        long end = System.currentTimeMillis();
        return end - start;
    }
}
