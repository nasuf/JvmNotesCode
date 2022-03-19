package com.nasuf.jdk8;

import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class ReturnAddressTest {

    // 默认构造器也是return

    // ireturn
    public boolean methodBoolean() { return false; }

    // ireturn
    public byte methodByte() { return 0; }

    // ireturn
    public short methodShort() { return 0; }

    // ireturn
    public char methodChar() { return 'a'; }

    // ireturn
    public int methodInt() { return 0; }

    // lreturn
    public long methodLong() { return 0L; }

    // freturn
    public float methodFloat() { return 0.0f; }

    // dreturn
    public double methodDouble() { return 0.0; }

    // areturn:引用类型
    public String methodString() { return null; }

    // areturn:引用类型
    public Date methodDate() { return null; }

    // return
    public void methodVoid() { }

    static {
        int i = 10;
    }

    public void method2() {
        try {
            method1();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void method1() throws IOException {
        FileReader fis = new FileReader("test.txt");
        char[] cBuffer = new char[1024];
        int len;
        while((len = fis.read(cBuffer)) != -1) {
            String str = new String(cBuffer, 0, len);
            System.out.println(str);
        }
        fis.close();
    }
}
