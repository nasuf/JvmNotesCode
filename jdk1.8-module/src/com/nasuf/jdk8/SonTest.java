package com.nasuf.jdk8;

public class SonTest {
    public static void main(String[] args) {
        Parent p = new Sub();
        System.out.println(p.x);
    }

}


class Parent {
    int x = 10;
    public Parent() {
        this.print();
        x = 20;
    }

    public void print() {
        System.out.println("Parent.x = " + x);
    }
}

class Sub extends Parent {
    int x = 30;
    public Sub() {
        this.print();
        x = 40;
    }
    public void print() {
        System.out.println("Sub.x = " + x);
    }
}