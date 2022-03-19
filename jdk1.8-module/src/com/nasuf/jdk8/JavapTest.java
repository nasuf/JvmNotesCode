package com.nasuf.jdk8;

public class JavapTest {
    private int num;
    boolean flag;
    protected char gender;
    public String info;

    public static final int COUNT = 1;
    static {
        String url = "www.atguigu.com";
    }

    {
        info = "java";
    }

    public JavapTest() { }

    private JavapTest(boolean flag) {
        this.flag = flag;
    }

    int getNum(int i) {
        return num + i;
    }

    protected char showGender() {
        return gender;
    }

    public void showInfo() {
        int i = 10;
        System.out.println(info + i);
    }
}
