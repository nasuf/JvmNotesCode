package com.nasuf.jdk8;

public class IfSwitchGotoTest {

    public void compare1() {
        int a = 0;
        if (a == 0) {
            a = 10;
        } else {
            a = 20;
        }
    }

    public boolean compareNull(String str) {
        if (str == null) {
            return true;
        } else {
            return false;
        }
    }

    public void compare2() {
        float f1 = 9;
        float f2 = 10;
        System.out.println(f1 < f2);
    }

    public void compare3() {
        int i1 = 10;
        long l1 = 20;
        System.out.println(i1 < l1);
    }

    public int compare4(double d) {
        if (d > 50.0) {
            return 1;
        } else {
            return -1;
        }
    }

    public void ifCompare1() {
        int i = 10;
        int j = 20;
        System.out.println(i < j);
    }

    public void ifCompare2() {
        short s1 = 9;
        byte b1 = 10;
        System.out.println(s1 > b1);
    }

    public void ifCompare3() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        System.out.println(obj1 == obj2);
        System.out.println(obj1 != obj2);
    }

    public void switchTest1(int select) {
        int num;
        switch (select) {
            case 1:
                num = 10;
                break;
            case 2:
                num = 20;
//                break;
            case 3:
                num = 30;
                break;
            default:
                num = 40;
        }
    }

    public void switchTest2(int select) {
        int num;
        switch (select) {
            case 100:
                num = 10;
                break;
            case 500:
                num = 20;
                break;
            case 200:
                num = 30;
                break;
            default:
                num = 40;
        }
    }

    // JDK7 新特性：引入string类型作为switch的key
    public void switchTest3(String season) {
        switch (season) {
            case "SPRING": break;
            case "SUMMER": break;
            case "AUTUMN": break;
            case "WINTER": break;
        }
    }

    public void whileInt() {
        int i = 0;
        while ( i < 100 ) {
            String s = "nasuf";
            i++;
        }
    }

    public void whileDouble() {
        double d = 0.0;
        while ( d < 100.1 ) {
            String s = "nasuf";
            d++;
        }
    }

    public void printFor() {
        short i;
        for (i = 0; i < 100; i++) {
            String s = "nasuf";
        }
    }

    public void doWhileTest() {
        int i = 1;
        do {
            i++;
        } while (i <= 100);
    }

}
